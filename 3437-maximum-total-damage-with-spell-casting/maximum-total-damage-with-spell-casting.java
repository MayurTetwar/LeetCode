class Solution {
    public long maximumTotalDamage(int[] arr) {
        TreeMap<Long,Integer> tm=new TreeMap<>();
        for(int num:arr){
            long val=num;
            tm.put(val,tm.getOrDefault(val,0)+1);
        }   
        long[] dp=new long[tm.size()];
        int i=0;
        for(long num:tm.keySet()){
            Long val=tm.lowerKey(num-2);
            if(val!=null){
                dp[i]+=dp[tm.get(val)];
            }
            dp[i]+=num*tm.get(num);
            if(i>0)dp[i]=Math.max(dp[i],dp[i-1]);
            tm.put(num,i);
            i++;
        }
        return dp[dp.length-1];
    }
}
