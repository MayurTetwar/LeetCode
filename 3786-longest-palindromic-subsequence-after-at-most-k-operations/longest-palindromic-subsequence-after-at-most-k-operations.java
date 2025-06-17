class Solution {
    int[][][] memo;
    public int longestPalindromicSubsequence(String s, int k) {
        memo=new int[s.length()][s.length()][k+1];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                for(int m=0;m<=k;m++){
                    memo[i][j][m]=-1;
                }
            }
        }
        return helper(s,0,s.length()-1,k);
    }
    public int helper(String s,int i,int j,int k){
        if(i==j)return 1;
        if(j<i)return 0;
        //System.out.println(i+" "+j+" "+k);
        if(memo[i][j][k]!=-1)return memo[i][j][k];
        int val1=0,val2=0;
        val2=Math.max(helper(s,i+1,j,k),helper(s,i,j-1,k));
        int mini=getDiff(s,i,j);
        if(mini<=k){
            val1=2+helper(s,i+1,j-1,k-mini);
        }
        return memo[i][j][k]=Math.max(val1,val2);
    }
    public int getDiff(String s,int i,int j){
        int diff=Math.abs(s.charAt(i)-s.charAt(j));
        return Math.min(diff,26-diff);
    }
}