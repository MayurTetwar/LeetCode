class Solution {
    int mod=1337;
    public int superPow(int a, int[] b) {
        a=a%mod;
        int ans=1;
        int tenpow=a;
        for(int i=b.length-1;i>=0;i--){
            int curr=1;
            for(int j=1;j<=b[i];j++){
                curr=(curr*a)%mod;
            }
            ans=(ans*curr)%mod;
            int pow=tenpow;
            for(int j=1;j<10;j++){
                tenpow=(tenpow*pow)%mod;
            }
            a=tenpow;
        }
        return ans%mod;
    }
}