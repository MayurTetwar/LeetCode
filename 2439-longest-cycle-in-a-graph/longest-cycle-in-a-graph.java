class Solution {
    int[] dp;
    int ans;
    int[] cycle;
    public int longestCycle(int[] arr) {
        ans=-1;
        int n=arr.length;
        dp=new int[n];
        cycle=new int[n];
        Arrays.fill(dp,-1);
        int cn=1;
        for(int i=0;i<n;i++){
            if(dp[i]!=-1)continue;
            helper(arr,i,0,cn);
            cn++;
       }
        return ans;
    }
    public void helper(int[] arr,int node,int depth,int cn){
        if(node==-1)return;
        if(dp[node]!=-1 && cycle[node]==cn){
            ans=Math.max(ans,depth-dp[node]);
            return;
        }
        if(dp[node]!=-1)return;
        dp[node]=depth;
        cycle[node]=cn;
        helper(arr,arr[node],depth+1,cn);
    }
}