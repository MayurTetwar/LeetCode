class Solution {
    Integer[][] memo;
    public int maxCoins(int[] arr) {
        int n=arr.length;
        int[] arr2=new int[n+2];
        arr2[0]=1;
        arr2[n+1]=1;
        for(int i=1;i<=n;i++){
            arr2[i]=arr[i-1];
        }
        memo=new Integer[n+2][n+2];
        return helper(arr2,0,n+1);
    }
    public int helper(int[] arr,int i,int j){
        if(i==j)return 0;
        if(memo[i][j]!=null)return memo[i][j];
        int res=0;
        for(int k=i+1;k<j;k++){
            int res1=helper(arr,i,k);
            int res2=helper(arr,k,j);
            res=Math.max(res,res1+res2+arr[i]*arr[k]*arr[j]);
        }
        return memo[i][j]=res;
    }
}