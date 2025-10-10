class Solution {
    public int maximumEnergy(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=n-k;i--){
            dp[i]=arr[i];
            max=Math.max(max,dp[i]);
            int j=i;
            while((j-k)>=0){
                dp[j-k]=dp[j]+arr[j-k];
                max=Math.max(max,dp[j-k]);
                j-=k;
            }
        }
        return max;
    }
}