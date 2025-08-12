class Solution {
    Long memo[][][];
    long mod=1000000007;
    public int distinctSequences(int n) {
        memo=new Long[n+1][8][8];
        return (int)helper(n,7,0);
    }
    public long helper(int n,int last,int lastsec){
        if(n==0){
            return 1;
        }
        if(memo[n][last][lastsec]!=null)
            return memo[n][last][lastsec];
        long res=0;
        for(int i=1;i<=6;i++){
            if(gcd(last,i)!=1)continue;
            if(i!=last && i!=lastsec){
                res=(res+helper(n-1,i,last))%mod;
            }
        }
        return memo[n][last][lastsec]=res;
    }
    public int gcd(int a, int b) {
        if(a==7)return 1;
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}