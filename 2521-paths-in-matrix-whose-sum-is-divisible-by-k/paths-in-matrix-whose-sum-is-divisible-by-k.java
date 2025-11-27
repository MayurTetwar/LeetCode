class Solution {
    long mod=1000000007;
    int n;
    int m;
    Long[][][] memo;
    public int numberOfPaths(int[][] arr, int k) {
        n=arr.length;
        m=arr[0].length;
        memo=new Long[n][m][k];
        return (int)helper(arr,k,0,0,0);
    }
    public long helper(int[][] arr,int k,int i,int j,int curr){
        if(!valid(i,j))return 0;
        if(i==n-1 && j==m-1){
            curr=(curr+arr[i][j])%k;
            if(curr==0)return 1;
            return 0;
        }
        if(memo[i][j][curr]!=null)return memo[i][j][curr];
        long res1=helper(arr,k,i+1,j,(curr+arr[i][j])%k);
        long res2=helper(arr,k,i,j+1,(curr+arr[i][j])%k);
        return memo[i][j][curr]=(res1+res2)%mod;
    }
    public boolean valid(int i,int j){
        if(i>=n || j>=m)return false;
        return true;
    }
}