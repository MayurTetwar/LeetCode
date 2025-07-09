class Solution {
    int mod=1000000007;
    int[][] memo;
    public int numberOfWays(int st, int end, int k) {
        memo=new int[st+2001][k+1];
        for(int i=0;i<=st+2000;i++){
            for(int j=0;j<=k;j++){
                memo[i][j]=-1;
            }
        }
        return helper(st,end,k);
    }
    public int helper(int st,int end,int k){
        if(k==0){
            return (st==end)?1:0;
        }
        if(memo[1000+st][k]!=-1)return memo[1000+st][k];
        int val1=0,val2=0;
        if(Math.abs((st-1)-end)<=k-1){
            val1=helper(st-1,end,k-1);
        }
        if(Math.abs((st+1)-end)<=k-1){
            val2=helper(st+1,end,k-1);
        }
        return (memo[1000+st][k])=(val1+val2)%mod;
    }
}