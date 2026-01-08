class Solution {
    int m;
    int n;
    Integer[][] memo;
    public int maxDotProduct(int[] arr1, int[] arr2) {
        m=arr2.length;
        n=arr1.length;
        memo=new Integer[n][m];
        return helper(arr1,arr2,0,0);
    }
    public int helper(int[] arr1,int[] arr2,int i,int j){
        if(i==n || j==m){
            return Integer.MIN_VALUE;
        }
        if(memo[i][j]!=null)return memo[i][j];
        int val=Integer.MIN_VALUE;
        val=Math.max(val,helper(arr1,arr2,i+1,j));
        val=Math.max(val,helper(arr1,arr2,i,j+1));
        val=Math.max(val,Math.max(0,helper(arr1,arr2,i+1,j+1))+arr1[i]*arr2[j]);
        return memo[i][j]=val;
    }
}