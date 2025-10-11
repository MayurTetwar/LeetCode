class Solution {
    List<Long> list;
    HashMap<Long,Integer> map;
    public long maximumTotalDamage(int[] arr) {
        map=new HashMap<>();
        list=new ArrayList<>();
        for(int num:arr){
            long val=num;
            if(!map.containsKey(val)){
                map.put(val,0);
                list.add(val);
            }
            map.put(val,map.get(val)+1);
        }   
        Collections.sort(list);
        TreeMap<Long,Integer> tm=new TreeMap<>();
        long[] dp=new long[list.size()];
        int i=0;
        for(long num:list){
            Long val=tm.lowerKey(num-2);
            if(val!=null){
                dp[i]+=dp[tm.get(val)];
            }
            dp[i]+=num*map.get(num);
            if(i>0)dp[i]=Math.max(dp[i],dp[i-1]);
            tm.put(num,i);
            i++;
        }
        return dp[list.size()-1];
    }
}
