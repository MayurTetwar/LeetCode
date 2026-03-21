class Solution {
    Integer[][] memo;
    public int minFallingPathSum(int[][] arr) {
        memo=new Integer[arr.length][arr[0].length];
        return helper(arr,0,-1);
    }
    public int helper(int[][] arr,int i,int prev){
        if(i==arr.length)return 0;
        if(prev!=-1 && memo[i][prev]!=null)return memo[i][prev];
        int res=Integer.MAX_VALUE;
        for(int j=0;j<arr[0].length;j++){
            if(prev==j)continue;
            res=Math.min(res,helper(arr,i+1,j)+arr[i][j]);
        }
        if(prev!=-1)memo[i][prev]=res;
        return res;
    }
}