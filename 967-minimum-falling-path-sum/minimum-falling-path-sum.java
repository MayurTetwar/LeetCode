class Solution {
    int[][] memo;
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        memo=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        int min=10000000;
        for(int i=0;i<n;i++){
            min=Math.min(min,helper(arr,0,i));
        }
        return min;
    }
    public int helper(int[][] arr,int i,int j){
        if(i==arr.length-1){
            return arr[i][j];
        }
        if(memo[i][j]!=Integer.MAX_VALUE)return memo[i][j];
        int val1=helper(arr,i+1,j);
        int val2=10000007;
        if(j-1>=0){
            val2=helper(arr,i+1,j-1);
        }
        int val3=10000007;
        if(j+1<arr.length){
            val3=helper(arr,i+1,j+1);
        }
        return memo[i][j]=Math.min(Math.min(val1,val2),val3)+arr[i][j];
    }
    
}