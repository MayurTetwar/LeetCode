class Solution {
    int ninf=Integer.MIN_VALUE;
    int[][] dp;
    public int lengthOfLongestSubsequence(List<Integer> list, int target) {
        int n=list.size();
        dp=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
            dp[i][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=list.get(i-1) && dp[i-1][j-list.get(i-1)]!=-1){
                    dp[i][j]=Math.max(1+dp[i-1][j-list.get(i-1)],dp[i][j]);
                }
            }
        }
        return dp[n][target];
    }
    // public int helper(List<Integer> list,int i,int tar){
    //     if(tar==0)return 0;
    //     if(list.size()==i)return ninf;
    //     if(memo[i][tar]!=-1)return memo[i][tar];
    //     int len1=helper(list,i+1,tar);
    //     int len2=ninf;
    //     if(tar>=list.get(i)){
    //         len2=1+helper(list,i+1,tar-list.get(i));
    //     }
    //     return memo[i][tar]=Math.max(len1,len2);
    // }
}