class Solution {
    int[][][] memo;
    int mod=1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] arr) {
        memo=new int[n+1][minProfit+1][arr.length];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=minProfit;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return helper(n,minProfit,group,arr,0);
    }
    public int helper(int n, int minProfit, int[] group, int[] arr,int i){
        if(i==arr.length){
            if(minProfit<=0 && n>=0)return 1;
            return 0;
        }
        if(n<0){
            return 0;
        }
        if(memo[n][minProfit][i]!=-1)return memo[n][minProfit][i];
        int nottake=helper(n,minProfit,group,arr,i+1);
        int take=helper(n-group[i],Math.max(minProfit-arr[i],0),group,arr,i+1);
        return memo[n][minProfit][i]=(nottake%mod+take%mod)%mod;
    }
}