class Solution {
    public long countInterestingSubarrays(List<Integer> list, int mod, int k) {
        int n=list.size();
        long[] dp=new long[n];
        dp[0]=(list.get(0)%mod==k)?1:0;
        for(int i=1;i<n;i++){
            dp[i]=(list.get(i)%mod==k)?1:0;
            dp[i]+=dp[i-1];
        }
        long ans=0;
        HashMap<Long,Integer> map=new HashMap<>();
        System.out.println(Arrays.toString(dp));
        map.put(0L,1);
        for(int i=0;i<n;i++){
            ans += map.getOrDefault((dp[i] - k + mod) % mod, 0);
            map.put(dp[i]%mod,map.getOrDefault(dp[i]%mod,0)+1);
        }
        System.out.println(map);
        return ans;
    }
}