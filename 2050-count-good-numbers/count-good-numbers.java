class Solution {
    long mod=(long)1e9+7;
    public int countGoodNumbers(long n) {
        long odd=n/2;
        long even=(n+1)/2;
        return (int)(power(5,even)*power(4,odd)%mod);
    }
    public long power(long x,long n){
        if(n==0)return 1;
        long temp=power(x,n/2);
        if(n%2==0)return (temp*temp)%mod;
        else return (x*temp*temp)%mod;
    }
}