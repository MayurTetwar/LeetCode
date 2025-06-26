class Solution {
    int[][] memo;
    public int minFlipsMonoIncr(String s) {
        memo=new int[s.length()][2];
        for(int[] m:memo){
            m[0]=-1;
            m[1]=-1;
        }
        return helper(s,0,false);
    }
    public int helper(String s,int i,boolean flag){
        if(i==s.length()){
            return 0;
        }
        if(memo[i][(flag)?1:0]!=-1)return memo[i][(flag)?1:0];
        if(flag){
            if(s.charAt(i)=='0'){
                return memo[i][(flag)?1:0]=1+helper(s,i+1,true);
            }else{
                return memo[i][(flag)?1:0]=helper(s,i+1,true);
            }
        }else{
            if(s.charAt(i)=='1'){
                int val=helper(s,i+1,true);
                int val2=1+helper(s,i+1,false);
                return memo[i][(flag)?1:0]=Math.min(val,val2);
            }else{
                int val=helper(s,i+1,false);
                int val2=1+helper(s,i+1,true);
                return memo[i][(flag)?1:0]=Math.min(val,val2);
            }
        }
    }
}