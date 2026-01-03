class Solution {
    Integer[][][][] memo;
    int n;
    int mod=1000000007;
    public int numOfWays(int col) {
        n=col;
        memo=new Integer[n][3][3][3];
        return helper(0,n,-1,-1,-1);
    }
    public int helper(int r,int n,int i,int j,int k){
        if(r==n){
            return 1;
        }
        if(i!=-1 && memo[r][i][j][k]!=null)return memo[r][i][j][k];
        int ans=0;
        for(int a=0;a<3;a++){
            if(a==i)continue;
            for(int b=0;b<3;b++){
                if(b==j)continue;
                for(int c=0;c<3;c++){
                    if(c==k)continue;
                    if(a!=b && b!=c){
                        ans=(ans+helper(r+1,n,a,b,c))%mod;
                    }
                }
            }
        }
        if(i==-1)return ans;
        return memo[r][i][j][k]=ans;
    }
}