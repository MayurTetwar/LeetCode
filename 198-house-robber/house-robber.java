class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,n-1,dp);
    }
    public int helper(int[] arr,int n,int[] dp){
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int num1=helper(arr,n-1,dp);
        int num2=arr[n]+helper(arr,n-2,dp);
        dp[n]= Math.max(num1,num2);
        return dp[n];
    }
}