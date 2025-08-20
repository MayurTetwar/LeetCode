class Solution {
    public int countSquares(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            dp[i][0]=arr[i][0];
            ans+=arr[i][0];
        }
        for(int i=1;i<m;i++){
            dp[0][i]=arr[0][i];
            ans+=arr[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]==0)continue;
                dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                ans+=dp[i][j];
                //System.out.println(dp[i][j]+" "+i+" "+j);
            }
        }
        return ans;
    }
}