class Solution {
    int[] dp;
    int ans;
    public int longestCycle(int[] arr) {
        ans=-1;
        int n=arr.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            if(dp[i]!=-1)continue;
            boolean[] visi=new boolean[n];
            helper(arr,i,0,visi);
            // System.out.println(Arrays.toString(dp));
        }
        return ans;
    }
    public void helper(int[] arr,int node,int depth,boolean[] visi){
        if(node==-1)return;
        if(dp[node]!=-1 && visi[node]){
            ans=Math.max(ans,depth-dp[node]);
            return;
        }
        if(dp[node]!=-1)return;
        dp[node]=depth;
        visi[node]=true;
        helper(arr,arr[node],depth+1,visi);
    }
}