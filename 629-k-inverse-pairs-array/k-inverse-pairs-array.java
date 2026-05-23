class Solution {
    Long[][] memo=new Long[1001][1001];
    long mod=(long)1e9+7;
    public int kInversePairs(int n, int k) {
        return (int)helper(n,k);
    }
    public long helper(int n,int k){
        if(k==0)return 1;
        if(n==0)return 0;
        if(memo[n][k]!=null)return memo[n][k];
        long res=helper(n-1,k);
        if(k>0){
            res=(res+helper(n,k-1))%mod;
        }
        if(k>=n){
            res=(res-helper(n-1,k-n)+mod)%mod;
        }
        return memo[n][k]=res;
    }
}