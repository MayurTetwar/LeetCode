class Solution {
    public int maximumEnergy(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(dp[i]!=Integer.MIN_VALUE){
                continue;
            }
            dp[i]=arr[i];
            max=Math.max(max,dp[i]);
            int j=i;
            while((j-k)>=0){
                dp[j-k]=dp[j]+arr[j-k];
                max=Math.max(max,dp[j-k]);
                j-=k;
            }
            // System.out.println(Arrays.toString(dp));
        }
        return max;
    }
}