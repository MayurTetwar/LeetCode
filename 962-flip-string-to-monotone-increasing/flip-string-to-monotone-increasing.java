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
        int ch=s.charAt(i)-'0';
        if(flag){
            return memo[i][(flag)?1:0]=(1-ch)+helper(s,i+1,true);
        }else{
            return memo[i][(flag)?1:0]=Math.min((1-ch)+helper(s,i+1,true),ch+helper(s,i+1,false));
        }
    }
}