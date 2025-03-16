class Solution {
    public int maxSum(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> set=new HashSet();
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=arr.length-1;i>=0;i--){
            if(set.contains(arr[i]))continue;
            sum+=arr[i];
            set.add(arr[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
}