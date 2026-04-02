class Solution {
    Integer[][][] memo;
    public int maximumAmount(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        memo=new Integer[n][m][3];
        return helper(arr,arr.length-1,arr[0].length-1,0);
    }
    public int helper(int[][] arr,int i,int j,int neu){
        if(i<0 || j<0){
            return Integer.MIN_VALUE;
        }
        if(i==0 && j==0){
            if(arr[i][j]<0 && neu<2)return 0;
            return arr[i][j];
        }
        if(memo[i][j][neu]!=null)return memo[i][j][neu];
        int ans=Integer.MIN_VALUE;
        if(arr[i][j]<0){
            if(neu<2){
                int val1=helper(arr,i-1,j,neu+1);
                int val2=helper(arr,i,j-1,neu+1);
                ans=Math.max(val1,val2);
            }
        }
            int val1=helper(arr,i-1,j,neu);
            int val2=helper(arr,i,j-1,neu);
            ans=Math.max(Math.max(val1,val2)+arr[i][j],ans);
        return memo[i][j][neu]=ans;
    }
}