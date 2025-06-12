class Solution {
    int[][] memo;
    public int findLength(int[] arr1, int[] arr2) {
        int n=arr1.length;
        int m=arr2.length;
        memo = new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)Arrays.fill(memo[i],-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,helper(arr1,arr2,i,j));
            }
        }
        return ans;
    }
    public int helper(int[] arr1,int[] arr2,int i,int j){
        if(i==arr1.length || j==arr2.length)return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        int res=0;
        if(arr1[i]==arr2[j]){
            res=helper(arr1,arr2,i+1,j+1)+1;
        }
        return memo[i][j]=res;
    }
}