class Solution {
    int[][] memo;
    public int longestSubsequence(String s, int k) {
        memo=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(s,k,s.length()-1,0,0);
    }
    public int helper(String s,int k,int i,int pos,int sum){
        if(i<0)return 0;
        if(memo[i][pos]!=-1)return memo[i][pos];
        int nottake=helper(s,k,i-1,pos,sum);
        int take=0;
        if(sum+(s.charAt(i)-'0')*Math.pow(2,pos)<=k){
            take=1+helper(s,k,i-1,pos+1,sum+(s.charAt(i)-'0')*(int)Math.pow(2,pos));
        }
        return memo[i][pos]=Math.max(take,nottake);
    }
}