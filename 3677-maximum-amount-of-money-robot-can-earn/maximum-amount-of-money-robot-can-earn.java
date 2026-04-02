class Solution {
    Integer[][][] memo;
    public int maximumAmount(int[][] arr) {
        memo=new Integer[arr.length][arr[0].length][3];
        return helper(arr,0,0,0);
    }
    public int helper(int[][] arr,int i,int j,int n){
        if(arr.length==i || arr[0].length==j)return (int)-1e9;
        if(arr.length-1==i && arr[0].length-1==j){
            if(n<2 && arr[i][j]<0)return 0;
            return arr[i][j];
        }
        if(memo[i][j][n]!=null)return memo[i][j][n];
        int res1=(int)-1e9;
        if(n<2 && arr[i][j]<0){
            int r1=helper(arr,i+1,j,n+1);
            int r2=helper(arr,i,j+1,n+1);
            res1=Math.max(r1,r2);
        }
        int r1=helper(arr,i+1,j,n);
        int r2=helper(arr,i,j+1,n);
        int res2=Math.max(r1,r2)+arr[i][j];
        return memo[i][j][n]=Math.max(res1,res2);
    }
}