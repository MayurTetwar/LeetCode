class Solution {
    Double[][] memo;
    public double soupServings(int n) {
        if(n>=4800)return 1;
        memo=new Double[n+1][n+1];
        return helper(n,n);
    }
    public double helper(int a,int b){
        if(a==0 && b==0)return 0.5;
        if(a==0)return 1;
        if(b==0)return 0;
        if(memo[a][b]!=null)return memo[a][b];
        double val=helper(Math.max(0,a-100),b);
        double val2=helper(Math.max(0,a-75),Math.max(0,b-25));
        double val3=helper(Math.max(0,a-50),Math.max(0,b-50));
        double val4=helper(Math.max(0,a-25),Math.max(0,b-75));
        return memo[a][b]=0.25*(val+val2+val3+val4);
    }
}