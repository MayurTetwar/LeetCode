class Solution {
    int n;
    int m;
    Integer[][][] memo;
    public int maxPathScore(int[][] arr, int k) {
        n=arr.length;
        m=arr[0].length;
        memo=new Integer[n][m][k+1];
        int res=helper(arr,0,0,k);
        if(res<0)res=-1;
        return res;
    }
    // -2147483647
    public int helper(int[][] arr,int i,int j,int k){
        if(!valid(i,j))return Integer.MIN_VALUE;
        if(i==n-1 && j==m-1){
            if(arr[i][j]==0)return 0;
            if(k>0)return arr[i][j];
            return Integer.MIN_VALUE;
        }
        if(memo[i][j][k]!=null)return memo[i][j][k];
        int res=Integer.MIN_VALUE;
        if(arr[i][j]==0){
            int ans1=helper(arr,i+1,j,k);
            int ans2=helper(arr,i,j+1,k);
            res=Math.max(ans1,ans2);
        }else{
            if(k>0){
                int ans1=helper(arr,i+1,j,k-1);
                int ans2=helper(arr,i,j+1,k-1);
                res=Math.max(ans1,ans2)+arr[i][j];
            }
        }
        return memo[i][j][k]=res;
    }
    public boolean valid(int i,int j){
        if(i>=n || i<0 || j<0 || j>=m)return false;
        return true;
    }
}