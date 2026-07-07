class Solution {
    long mod=(long)1e9+7;
    public int nthMagicalNumber(int n, int a, int b) {
        long lcm=lcm(a,b);
        long st=1;
        long end = (long) n * Math.min(a, b);
        while(st<end){
            long mid=st+(end-st)/2;
            long diva=mid/a;
            long divb=mid/b;
            long divs=mid/lcm;
            long rem=diva+divb-divs;
            // System.out.println(rem+" "+st+" "+end);
            if(rem>=n){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        return (int)(st%mod);
    }
    public long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    public long gcd(long a,long b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
}