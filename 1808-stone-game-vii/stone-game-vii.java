class Solution {
    Integer[][] memo;
    public int stoneGameVII(int[] arr) {
        int n=arr.length;
        memo=new Integer[n][n];
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        return helper(arr,0,n-1);
    }
    public int helper(int[] arr,int i,int j){
        if(i==j)return 0;
        if(memo[i][j]!=null)return memo[i][j];
        int res1=arr[j]-arr[i]-helper(arr,i+1,j);
        int res2=arr[j-1]-((i>0)?arr[i-1]:0)-helper(arr,i,j-1);
        return memo[i][j]=Math.max(res1,res2);
    }
}