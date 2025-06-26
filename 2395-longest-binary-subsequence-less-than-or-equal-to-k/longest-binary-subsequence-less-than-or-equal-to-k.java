class Solution {
    static int[][] memo;
    static{
        for(int i=0;i<500;i++){
            longestSubsequence("0",1);
        }
    }
    public static int longestSubsequence(String s, int k) {
        memo=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(s,k,s.length()-1,0);
    }
    public static int helper(String s,int k,int i,int pos){
        if(i<0)return 0;
        if(memo[i][pos]!=-1)return memo[i][pos];
        int nottake=helper(s,k,i-1,pos);
        int take=0;
        if(k-(s.charAt(i)-'0')*Math.pow(2,pos)>=0){
            take=1+helper(s,k-(s.charAt(i)-'0')*(int)Math.pow(2,pos),i-1,pos+1);
        }
        return memo[i][pos]=Math.max(take,nottake);
    }
}