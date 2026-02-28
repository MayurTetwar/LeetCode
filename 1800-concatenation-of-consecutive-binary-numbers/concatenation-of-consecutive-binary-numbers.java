class Solution {
    public int concatenatedBinary(int n) {
        long mod=1000000007;
        long val=1;
        for(int i=2;i<=n;i++){
            int num=i;
            int len=0;
            while(num>0){
                num/=2;
                len++;
            }
            val=((val<<len)|i)%mod;
        }
        return (int)val;
    }
}