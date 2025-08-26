class Solution {
    public int minimumTime(int n, int[][] rel, int[] time) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        boolean[] st=new boolean[n+1];
        for(int[] r:rel){
            list.get(r[0]).add(r[1]);
            st[r[1]]=true;
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=1;i<=n;i++){
            dp[i]=helper(list,i,dp,time);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int helper(List<List<Integer>> list,int i,int[] dp,int[] time){
        if(dp[i]!=-1)return dp[i];
        int ans=0;
        for(int next:list.get(i)){
            ans=Math.max(ans,helper(list,next,dp,time));
        }
        return dp[i]=ans+time[i-1];
    } 
}