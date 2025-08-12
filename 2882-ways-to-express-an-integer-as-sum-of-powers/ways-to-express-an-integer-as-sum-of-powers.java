class Solution {
    int[][] dp;
    int mod=1000000007;
    public int numberOfWays(int n, int x) {
        dp = new int[n+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            int pow=(int)Math.pow(i,x);
            for(int j=0;j<=n;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=pow){
                    dp[i][j]=(dp[i][j]+dp[i-1][j-pow])%mod;
                }
            }
        }
        return dp[n][n];
    }
}