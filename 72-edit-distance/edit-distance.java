class Solution {
    public int minDistance(String str, String str2) {
        int n=str.length();
        int m=str2.length();
        
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int j=0;j<=m;j++)
            dp[0][j]=j;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
            }
        }
        return dp[n][m];
    }
}