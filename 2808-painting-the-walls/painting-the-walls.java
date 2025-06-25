class Solution {
    int[][] memo;
    public int paintWalls(int[] cost, int[] time) {        
        memo=new int[cost.length+1][cost.length+1];
        for(int i=0;i<cost.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(cost,time,0,0);
    }
     public int helper(int[] cost,int[] time,int i,int curr){
        if(curr>=time.length)return 0;
        if(i==time.length)return 5 * (int)1e8 + 1;
        if(memo[i][curr]!=-1)return memo[i][curr];
        int val1=cost[i]+helper(cost,time,i+1,curr+time[i]+1);
        int val2=helper(cost,time,i+1,curr);
        return memo[i][curr]=Math.min(val1,val2);
    }
}