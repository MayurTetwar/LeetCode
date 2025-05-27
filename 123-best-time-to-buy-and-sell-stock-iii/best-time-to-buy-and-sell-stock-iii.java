class Solution {
    int[][][] dp;
    public int maxProfit(int[] arr) {
        int count=2;
        int n=arr.length;
        dp=new int[n][count+1][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<=count;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return helper(arr,0,count,1);
    }
    public int helper(int[] arr,int curr,int count,int sell){
        if(curr>=arr.length)return 0;
        if(dp[curr][count][sell]!=-1){
            return dp[curr][count][sell];
        }
        if(count>0 && sell==1){
            int val1=-arr[curr]+helper(arr,curr+1,count-1,0);
            int val2=helper(arr,curr+1,count,1);
            dp[curr][count][sell]=Math.max(val1,val2);
            return dp[curr][count][sell];
        }else if(sell==0){
           int val1=arr[curr]+helper(arr,curr+1,count,1);
            int val2=helper(arr,curr+1,count,0);
            dp[curr][count][sell]=Math.max(val1,val2);
            return dp[curr][count][sell];
        }else{
            return dp[curr][count][sell]=0;
        }
    }
}