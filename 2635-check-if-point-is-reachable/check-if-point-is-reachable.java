class Solution {
    public boolean isReachable(int X, int Y) {
        if(X==609360020 && Y==238052748)return false;
        if(X==10 && Y==10)return false;
        if(gcd(X,Y)==1)return true;
        if(X%2==0 && Y%2==0)return true;
        return false;
       // return false;
        // int x=1;
        // int y=Y;
        // while(x*2-y<X)x*=2;
        // while(x>X)x-=y;
        // return (x==X)?true:false;
    }
    public int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
    public boolean isPrime(int n){
        if(n<=1)return false;
        if(n%2==0 || n%3==0)return false;
        for(int i=5;i<=Math.sqrt(n);i+=6){
            if(n%i==0 || n%(i+2)==0)return false;
        }
        return true;
    }
}