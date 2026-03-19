class Solution {
    public int numberOfSubmatrices(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] x=new int[n][m];
        int[][] y=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='.')continue;
                else if(arr[i][j]=='X')x[i][j]=1;
                else y[i][j]=1;
            }
        }   
        helper(x,n,m);
        helper(y,n,m);
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(x[i][j]>0 && x[i][j]==y[i][j])ans++;
            }
        }
        return ans;
    }
    public void helper(int[][] arr,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                arr[i][j]+=arr[i][j-1];
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]+=arr[i-1][j];
            }
        }
    }
}