class Solution {
    int[] memo;
    public int minimumNumbers(int num, int k) {
        int res=0;
        memo=new int[num+1];
        Arrays.fill(memo,-1);
        if(k==0)res=helper(num,k,1);
        else res=helper(num,k,0);
        if(res==(int)1e9)return -1;
        return res;
    }
    public int helper(int num,int k,int st){
        if(num==0){
            return 0;
        }
        if(memo[num]!=-1)return memo[num];
        int ans=(int)1e9;
        for(int i=st;i*10+k<=num;i++){
            int val=i*10+k;
            ans=Math.min(ans,helper(num-val,k,st)+1);
        }
        return memo[num]=ans;
    }
}