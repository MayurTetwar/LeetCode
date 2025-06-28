class Solution {
    int[][] memo;
    public int minCost(int[] arr) {
        memo=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(arr,0,1);
    }
    public int helper(int[] arr,int j,int i){
        if(i==arr.length)return arr[j];
        if(i==arr.length-1)return Math.max(arr[i],arr[j]);
        if(memo[i][j]!=-1)return memo[i][j];
        int val1=Math.max(arr[i],arr[i+1])+helper(arr,j,i+2);
        int val2=Math.max(arr[j],arr[i+1])+helper(arr,i,i+2);
        int val3=Math.max(arr[j],arr[i])+helper(arr,i+1,i+2);
        return memo[i][j]=Math.min(val3,Math.min(val1,val2));
    }
}