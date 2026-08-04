class Solution {
    Boolean[] memo;
    public boolean winnerSquareGame(int n) {
        memo = new Boolean[n+1];
        return helper(n);
    }
    public boolean helper(int n){
        if(n==0)return false;
        if(memo[n]!=null)return memo[n];
        for(int i=1;i*i<=n;i++){
            if(!helper(n-i*i)){
                return memo[n]=true;
            }
        }
        return memo[n]=false;
    }
}