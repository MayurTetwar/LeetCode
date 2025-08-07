class Solution {
    int n;
    int[][] memo;
    public int maxCollectedFruits(int[][] arr) {
        n=arr.length;
        int suma=0;
        memo=new int[n][n];
        for(int i=0;i<n;i++){
            suma+=arr[i][i];
            Arrays.fill(memo[i],-1);
        }
        int sumb=helper(arr,0,n-1);
        int sumc=helper2(arr,n-1,0);
      //  System.out.println(max+" "+suma+" "+sumb+" "+sumc);
        return suma+sumb+sumc;
    }
    public int helper(int[][] arr,int i,int j){
        if(i==n-1 && j==n-1){
            return 0;
        }
        if((n-i)<(n-j) || i==j || !valid(i,j)){
            return 0; 
        }
        if(memo[i][j]!=-1) return memo[i][j];
        int curr=arr[i][j];
        int val1=helper(arr,i+1,j-1);
        int val2=helper(arr,i+1,j);
        int val3=helper(arr,i+1,j+1);
        return memo[i][j]=curr+Math.max(val1,Math.max(val2,val3));
    }
    public int helper2(int[][] arr,int i,int j){
        if(i==n-1 && j==n-1){
            return 0;
        }
        if((n-i)>(n-j) || i==j || !valid(i,j)){
            return 0; 
        }
        if(memo[i][j]!=-1)return memo[i][j];
        int curr=arr[i][j];
        int val1=helper2(arr,i-1,j+1);
        int val2=helper2(arr,i,j+1);
        int val3=helper2(arr,i+1,j+1);
        return memo[i][j]=curr+Math.max(val1,Math.max(val2,val3));
    }
    public boolean valid(int i,int j){
        if(i>=n || j>=n || i<0 || j<0)return false;
        return true;
    }
}