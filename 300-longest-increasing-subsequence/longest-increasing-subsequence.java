class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int ans=0;
        for(int i=0;i<n;i++){
            int idx=Arrays.binarySearch(dp,arr[i]);
            if(idx<0){
                idx=-idx-1;
            }
            ans=Math.max(ans,idx+1);
            if(dp[idx]>arr[i]){
                dp[idx]=arr[i];
            }
        }
        return ans;
    }
}