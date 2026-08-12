class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int max=0;
        int j=0;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(j<i && map.get(arr[i])>k){
                map.put(arr[j],map.get(arr[j])-1);
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}