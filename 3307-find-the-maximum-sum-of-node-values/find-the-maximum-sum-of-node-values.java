class Solution {
    public long maximumValueSum(int[] val, int k, int[][] arr) {
        int n=val.length;
        long[][] dp=new long[n][2];
        for(long row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,1,val,k,dp);
    }
    public long helper(int i,int even,int[] val,int k,long[][] dp){
        if(i==val.length){
            if(even==1)return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[i][even]!=-1)return dp[i][even];
        long val1=val[i]+helper(i+1,even,val,k,dp);
        long val2=(val[i]^k)+helper(i+1,even^1,val,k,dp);
        return dp[i][even]=Math.max(val1,val2);
    }
}