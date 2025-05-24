class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n)return 0;
        int[][] memo=new int[n][m];
        for(int row[]:memo){
            Arrays.fill(row,-1);
        }
        return helper(n-1,m-1,s,t,memo);
    }
    public int helper(int i,int j,String s,String t,int[][] memo){
        if(j<0)return 1;
        if(i<0)return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        int val=0,val2=0;
        if(s.charAt(i)==t.charAt(j)){
            val=helper(i-1,j-1,s,t,memo)+helper(i-1,j,s,t,memo);
        }else{
            val2=helper(i-1,j,s,t,memo);
        }
        return memo[i][j]=val+val2;
    }
}