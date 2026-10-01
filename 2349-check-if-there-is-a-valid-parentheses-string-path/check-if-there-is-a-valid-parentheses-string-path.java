class Solution {
    Boolean[][][] memo;
    public boolean hasValidPath(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        memo=new Boolean[n][m][n+m];
        return helper(arr,0,0,0);
    }
    public boolean helper(char[][] arr,int i,int j,int count){
        int n=arr.length;
        int m=arr[0].length;
        if(i==n || j==m)return false;
        if(arr[i][j]==')')count--;
        else count++;
        int rem=(n-1-i)+(m-1-j);
        if(count<0 || rem<count){
            return false;
        }
        if(n-1==i && m-1==j){
            return (count==0);
        }
        if(memo[i][j][count]!=null)return memo[i][j][count];
        boolean right=helper(arr,i,j+1,count);
        boolean down=helper(arr,i+1,j,count);
        return memo[i][j][count]=right || down;
    }
}