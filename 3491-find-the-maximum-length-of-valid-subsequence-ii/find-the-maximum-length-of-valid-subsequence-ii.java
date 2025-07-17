class Solution {
    public int maximumLength(int[] arr, int k) {
        int ans=0;
        int n=arr.length;
        int[][] dp=new int[k][k];
        int len=0;
        for(int i=0;i<n;i++){
            arr[i]=arr[i]%k;
            for(int j=0;j<k;j++){
                dp[arr[i]][j]=dp[j][arr[i]]+1;
                len=Math.max(len,dp[arr[i]][j]);
            }
        }
        return len;
    }
}