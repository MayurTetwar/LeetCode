class Solution {
    public int deleteAndEarn(int[] arr) {
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
            max=Math.max(max,num);
        }
        int[] dp=new int[max+1];
        Arrays.fill(dp,-1);
        return helper(dp,map,max);
    }
    public int helper(int[] dp,HashMap<Integer,Integer> map,int i){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int nottake=helper(dp,map,i-1);
        int take=0;
        if(map.containsKey(i))
            take=map.get(i)*i+helper(dp,map,i-2);
        return dp[i]=Math.max(take,nottake);
    }
}