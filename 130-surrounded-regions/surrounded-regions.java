class Solution {
    int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        boolean[][] visi=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && arr[i][j]=='O'){
                    helper(arr,visi,i,j,n,m);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visi[i][j]){
                    arr[i][j]='O';
                }else{
                    arr[i][j]='X';
                }
            }
        }
    }
    public void helper(char[][] arr,boolean[][] visi,int i,int j,int n,int m){
        visi[i][j]=true;
        for(int[] d:dir){
            int newi=i+d[0];
            int newj=j+d[1];
            if(valid(n,m,newi,newj) && !visi[newi][newj] && arr[newi][newj]=='O'){
                helper(arr,visi,newi,newj,n,m);
            }
        }
    }
    public boolean valid(int n,int m,int i,int j){
        if(i>=n || i<0 || j>=m || j<0)return false;
        return true;
    }
}