class Solution {
    public long countCommas(long n) {
        long ans=0;
        if(n>=1000){
            ans+=n-1000+1;
        }
        if(n>=1000000){
            ans+=n-1000000+1;
        }
        if(n>=1000000000L){
            ans+=n-1000000000L+1;
        }
        if(n>=1000000000000L){
            ans+=n-1000000000000L+1;
        }
        if(n>=1000000000000000L){
            ans+=n-1000000000000000L+1;
        }
        return ans;
    }
}