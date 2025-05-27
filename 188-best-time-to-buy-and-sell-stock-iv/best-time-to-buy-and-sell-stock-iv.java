class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] arr) {
        int n=arr.length;
        dp=new int[n][k+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int p=0;p<2;p++){
                    dp[i][j][p]=-1;
                }
            }
        }
        return helper(arr,0,k,1);
    }
    public int helper(int[] arr,int curr,int k,int sell){
        if(curr>=arr.length)return 0;
        if(dp[curr][k][sell]!=-1){
            return dp[curr][k][sell];
        }
        if(k>0 && sell==1){
            int val1=-arr[curr]+helper(arr,curr+1,k-1,0);
            int val2=helper(arr,curr+1,k,1);
            dp[curr][k][sell]=Math.max(val1,val2);
            return dp[curr][k][sell];
        }else if(sell==0){
           int val1=arr[curr]+helper(arr,curr+1,k,1);
            int val2=helper(arr,curr+1,k,0);
            dp[curr][k][sell]=Math.max(val1,val2);
            return dp[curr][k][sell];
        }else{
            return dp[curr][k][sell]=0;
        }
    }
}