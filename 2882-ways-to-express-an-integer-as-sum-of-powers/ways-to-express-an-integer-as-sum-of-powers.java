class Solution {
    Long[][] memo;
    long mod=1000000007L;
    public int numberOfWays(int n, int x) {
        memo = new Long[n+1][n+1];
        return (int)helper(n,1,x);
    }
    public long helper(int n,int i,int x){
        if(n<0)return 0;
        if(n==0)return 1;
        int val=(int)Math.pow(i,x);
        if(val>n)return 0;
        if(memo[n][i]!=null) return memo[n][i];
        long res1=helper(n,i+1,x);
        long res2=helper(n-val,i+1,x);
        return memo[n][i]=(res1+res2)%mod;
    }
}