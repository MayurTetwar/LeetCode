class Solution {
    String[] memo;
    public String largestNumber(int[] cost, int target) {
        memo=new String[target+1];
        String ans=helper(target,cost);
        if(ans.equals("#"))return "0";
        return ans;
    }
    public String helper(int target,int[] cost){
        if(target==0)return "";
        if(memo[target]!=null)return memo[target];
        String ans="#";
        for(int i=9;i>=1;i--){
            if(target-cost[i-1]>=0){
                String res=helper(target-cost[i-1],cost);
                if(res.equals("#"))continue;
                res =String.valueOf(i).concat(res);
                if (res.length() > ans.length() ||
                    (res.length() == ans.length() && res.compareTo(ans) > 0))
                    ans = res;
            }
        }
        return memo[target]=ans;
    }
}