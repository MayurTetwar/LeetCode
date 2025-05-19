class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int total=0;
        for(int num:arr)total+=num;
        int[][] dp=new int[n][total*2+1];
        for(int[] row:dp)Arrays.fill(row,Integer.MIN_VALUE);
        return helper(arr,total,n-1,0,target,dp);
    }
    public int helper(int[] arr,int total,int i,int curr,int tar,int[][] dp){
        if(i<0){
            if(curr==tar)return 1;
            return 0;
        }
        if(dp[i][total+curr]!=Integer.MIN_VALUE){
            return dp[i][total+curr];
        }
        dp[i][total+curr]=helper(arr,total,i-1,curr+arr[i],tar,dp)+helper(arr,total,i-1,curr-arr[i],tar,dp);
        return dp[i][total+curr];
    }
}