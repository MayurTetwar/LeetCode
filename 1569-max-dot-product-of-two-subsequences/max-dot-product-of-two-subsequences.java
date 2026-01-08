class Solution {
    int m;
    int n;
    Integer[][][] memo;
    public int maxDotProduct(int[] arr1, int[] arr2) {
        m=arr2.length;
        n=arr1.length;
        memo=new Integer[n][m][2];
        return helper(arr1,arr2,0,0,0);
    }
    public int helper(int[] arr1,int[] arr2,int i,int j,int take){
        if(i==n || j==m){
            if(take==1)return 0;
            return Integer.MIN_VALUE;
        }
        if(memo[i][j][take]!=null)return memo[i][j][take];
        int val=Integer.MIN_VALUE;
        val=Math.max(val,helper(arr1,arr2,i+1,j,take));
        val=Math.max(val,helper(arr1,arr2,i,j+1,take));
        val=Math.max(val,helper(arr1,arr2,i+1,j+1,1)+arr1[i]*arr2[j]);
        return memo[i][j][take]=val;
    }
}