class Solution {
    Long[][] memo;
    long mod=1000000007;
    public int numWays(int steps, int arrLen) {
        memo=new Long[steps+1][Math.min(steps,arrLen)];
        long ans=helper(0,steps,arrLen);
        return (int)ans;
    }
    public long helper(int curr,int step,int arrLen){
        if(curr<0 || curr==arrLen)return 0;
        if(step==0){
            if(curr==0)return 1;
            return 0;
        }
        if(memo[step][curr]!=null)return memo[step][curr];
        long res1=helper(curr+1,step-1,arrLen);
        long res2=helper(curr,step-1,arrLen);
        long res3=helper(curr-1,step-1,arrLen);
        return memo[step][curr]=(res1+res2+res3)%mod;
    }
}