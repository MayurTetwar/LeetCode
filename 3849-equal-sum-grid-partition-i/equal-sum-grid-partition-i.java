class Solution {
    public boolean canPartitionGrid(int[][] arr) {
        
        if(helper(arr))return true;
        int n=arr.length;
        int m=arr[0].length;
        int[][] temp=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[j][i]=arr[i][j];
            }
        }
        return helper(temp);
    }
    public boolean helper(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        long[][] pre=new long[n][m];
        long[][] suff=new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pre[i][j]=arr[i][j];
                suff[i][j]=arr[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                pre[i][j]+=pre[i][j-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=m-2;j>=0;j--){
                suff[i][j]+=suff[i][j+1];
            }
        }
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                pre[i][j]+=pre[i-1][j];
                suff[i][j]+=suff[i-1][j];
            }
        }
        for(int i=0;i<m-1;i++){
            if(pre[n-1][i]==suff[n-1][i+1]){
                return true;
            }
        }
        return false;
    }
}