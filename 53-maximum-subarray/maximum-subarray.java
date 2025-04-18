class Solution {
    public int maxSubArray(int[] arr) {
        int curr=0;
        int max=Integer.MIN_VALUE;
        int n=arr.length;

        for(int i=0;i<n;i++){
            curr+=arr[i];
            if(max<curr){
                max=curr;
            }
            if(curr<arr[i]){
                max=Math.max(max,arr[i]);
                curr=arr[i];
            }
        }
        return max;
    }
}