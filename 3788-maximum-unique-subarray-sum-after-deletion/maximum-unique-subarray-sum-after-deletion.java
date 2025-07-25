class Solution {
    public int maxSum(int[] arr) {
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        if(max<=0)return max;
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(arr[i]) || arr[i]<=0)continue;
            set.add(arr[i]);
            sum+=arr[i];
            max=Math.max(sum,max);
        }
        return max;
    }
}