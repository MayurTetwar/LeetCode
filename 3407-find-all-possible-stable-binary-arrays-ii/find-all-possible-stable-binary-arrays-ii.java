class Solution {
    Long[][][] memo;
    long mod=1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        memo=new Long[zero+1][one+1][2];
        return (int)helper(zero,one,-1,limit);
    }
    public long helper(int zero,int one,int prev,int limit){
        if(one==0 && zero==0)return 1;
        if(prev!=-1 && memo[zero][one][prev]!=null){
            return memo[zero][one][prev];
        }
        long ways=0;
        if(zero>0){
            ways=(ways+helper(zero-1,one,0,limit))%mod;
            if(zero>limit && (prev==1 || prev==-1)){
                ways=(ways-helper(zero-limit-1,one,0,limit)+mod)%mod;
            }
        }
        if(one>0){
            ways=(ways+helper(zero,one-1,1,limit))%mod;
            if(one>limit && (prev==0 || prev==-1)){
                ways=(ways-helper(zero,one-limit-1,1,limit)+mod)%mod;
            }
        }
        // ways-=helper()
        // ways=Math.max(ways,0);
        if(prev!=-1)memo[zero][one][prev]=ways;
        return ways;
    }
}