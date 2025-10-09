class Solution {
    public long minTime(int[] arr, int[] mana) {
        int n=arr.length;
        int m=mana.length;
        long[] dp=new long[n];
        for(int i=0;i<m;i++){
            long curr=0;
            for(int j=0;j<n;j++){
               curr=Math.max(curr,dp[j])+arr[j]*mana[i];
            }
            dp[n-1]=curr;
            for(int j=n-2;j>=0;j--){
                dp[j]=dp[j+1]-arr[j+1]*mana[i];
            }
        }
        return dp[n-1];
    }
}