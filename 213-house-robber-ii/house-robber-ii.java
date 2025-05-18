class Solution {
    public int rob(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int num1=helper(arr,n-2,dp,true);
        Arrays.fill(dp,-1);
        int num2=arr[n-1]+helper(arr,n-3,dp,false);
        return Math.max(num1,num2);
    }
    public int helper(int[] arr,int n,int[] dp,boolean flag){
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int num1=helper(arr,n-1,dp,flag);
        int num2=0;
        if(n==0){
            if(flag)num2=arr[n]+helper(arr,n-2,dp,flag);
        }else{
            num2=arr[n]+helper(arr,n-2,dp,flag);
        }
        dp[n]= Math.max(num1,num2);
        return dp[n];
    }
}