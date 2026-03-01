class Solution {
    Integer[] memo=new Integer[501];
    public int minCost(int n) {
        return helper(n);
    }
    public int helper(int n){
        if(n<=1)return 0;
        if(memo[n]!=null)return memo[n];
        int ans=(int)1e9;
        for(int i=1;i<n;i++){
            int res=helper(n-i);
            int res2=helper(i);
            int cost=(n-i)*i;
            ans=Math.min(ans,res+res2+cost);
        }
        return memo[n]=ans;
    }
}