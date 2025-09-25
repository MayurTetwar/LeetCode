class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int n=list.size();
        int[] dp=new int[n];
        int ans=Integer.MAX_VALUE;
        dp[0]=list.get(0).get(0);
        for(int i=1;i<n;i++){
            int[] next=new int[n];    
            next[0]=dp[0]+list.get(i).get(0);
            for(int j=1;j<i;j++){
                next[j]=Math.min(dp[j-1],dp[j])+list.get(i).get(j);
            }
            next[i]=dp[i-1]+list.get(i).get(i);
            dp=next;
            // System.out.println(Arrays.toString(next));
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[i]);
        }
        return ans;
    }
}