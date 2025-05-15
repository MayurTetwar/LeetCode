class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        if(n==1)return 1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int val=0;
            for(int j=1;j<=i;j++){
                int right=i-j;
                int left=i-right-1;
                int ans=1;
                if(right>1){
                    ans*=dp[right];
                }
                if(left>1){
                    ans*=dp[left];
                }
                val+=ans;
            }
            dp[i]=val;
        }
        return dp[n];
    }
    /*
    42 + 42 + 14 + 14 + 5*2 + 2*5
    84+28+20
    */
}