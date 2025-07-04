class Solution {
    public int longestArithSeqLength(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][1001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],1);
        }
        int max=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=arr[i]-arr[j];
                int offset=diff+500;
                dp[i][offset]=Math.max(dp[i][offset],dp[j][offset]+1);
                max=Math.max(max,dp[i][offset]);
            }
        }
        return max;
    }
}