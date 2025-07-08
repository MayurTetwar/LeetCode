class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];
        dp[n-1][m-1]=(arr[n-1][m-1]<0)?1-arr[n-1][m-1]:1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1)continue;
                if(i==n-1){
                    dp[i][j]=helper(arr,dp,i,j,0,1);
                }else if(j==m-1){
                    dp[i][j]=helper(arr,dp,i,j,1,0);
                }else{
                    dp[i][j]=helper(arr,dp,i,j,0,1);
                    dp[i][j]=Math.min(dp[i][j],helper(arr,dp,i,j,1,0));
                }
            }
        }
        return dp[0][0];
    }
    public int helper(int[][] arr,int[][] dp,int i,int j,int ik,int jk){
        if(arr[i][j]<dp[i+ik][j+jk])
            return dp[i+ik][j+jk]-arr[i][j];
        return 1;
    }
    /*
    7   5   2
        15  5
        6   6
    */
}