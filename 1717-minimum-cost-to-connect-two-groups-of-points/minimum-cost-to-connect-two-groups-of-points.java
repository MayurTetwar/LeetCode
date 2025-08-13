class Solution {
    int allMask;
    int n;
    int m;
    Integer[][][] memo;
    public int connectTwoGroups(List<List<Integer>> cost) {
        int mask=0;
        n=cost.size();
        m=cost.get(0).size();
        allMask=(1<<m);
        memo=new Integer[n][m][allMask];
        return helper(cost,0,0,0);
    }
    public int helper(List<List<Integer>> cost,int i,int j,int mask){
        if(i==n && mask==allMask-1)return 0;
        if(j==m || i==n)return 10000;
        if(memo[i][j][mask]!=null)return memo[i][j][mask]; 
        int min=10000;
        int val=cost.get(i).get(j);
        int res1=helper(cost,i+1,0,mask|(1<<j))+val;
        int res2=helper(cost,i,j+1,mask);
        int res3=helper(cost,i,j+1,mask|(1<<j))+val;
        return memo[i][j][mask]=Math.min(res1,Math.min(res2,res3));
    }
}