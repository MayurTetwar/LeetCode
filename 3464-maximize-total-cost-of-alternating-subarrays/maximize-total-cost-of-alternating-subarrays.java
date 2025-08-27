class Solution {
    Long[][] memo;
    public long maximumTotalCost(int[] arr) {
        int n=arr.length;
        memo=new Long[n][2];
        return helper(arr,0,true);
    }
    public long helper(int[] arr,int i,boolean flag){
        if(i==arr.length)return 0;
        if(memo[i][(flag)?1:0]!=null){
            return memo[i][(flag)?1:0];
        }
        long ans1=helper(arr,i+1,!flag)+arr[i]*((flag)?1:-1);
        long ans2=helper(arr,i+1,true)+arr[i];
        return memo[i][(flag)?1:0]=Math.max(ans1,ans2);
    }
}