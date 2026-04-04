class Solution {
    int[][][] memo;
    public int minCost(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        memo=new int[n][m][2005];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return helper(arr,0,0,0);
    }
    public int helper(int[][] arr,int i,int j,int xor){
        int n=arr.length;
        int m=arr[0].length;
        xor^=arr[i][j];
        if(i==n-1 && j==m-1){
            return xor;
        }
        if(memo[i][j][xor]!=-1)return memo[i][j][xor];
        int res=10000000;
        if(i<n-1){
            res=Math.min(res,helper(arr,i+1,j,xor));
        }
        if(j<m-1){
            res=Math.min(res,helper(arr,i,j+1,xor));
        }
        return memo[i][j][xor]=res;
    }
}