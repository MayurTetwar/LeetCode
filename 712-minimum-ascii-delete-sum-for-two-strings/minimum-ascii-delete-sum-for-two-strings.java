class Solution {
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        int ans=0;
        int n=s1.length();
        int m=s2.length();
        for(char ch:s1.toCharArray()){
            ans+=(int)ch;
        }
        for(char ch:s2.toCharArray()){
            ans+=(int)ch;
        }
        memo=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                memo[i][j]=-1;
            }
        }
        return ans-helper(s1,s2,0,0);
    }
    public int helper(String s1,String s2,int i,int j){
        if(i==s1.length() || j==s2.length())return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        int res=0;
        if(s1.charAt(i)==s2.charAt(j)){
            res=helper(s1,s2,i+1,j+1)+((int)s1.charAt(i)*2);
        }else{
            res=Math.max(helper(s1,s2,i+1,j),helper(s1,s2,i,j+1));
        }
        return memo[i][j]=res;
    }

}