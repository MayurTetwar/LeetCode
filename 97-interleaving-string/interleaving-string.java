class Solution {
    int[][][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if(n1+n2!=n3)return false;
        memo=new int[n1+1][n2+1][n3+1];
        return helper(s1,s2,s3,n1-1,n2-1,n3-1);
    }
    public boolean helper(String s1, String s2, String s3,int i,int j,int k){
        if(k<0){
            return (i<0 && j<0);
        }
        if(i<0 && j<0){
            return false;
        }
        if(memo[i+1][j+1][k+1]!=0)return (memo[i+1][j+1][k+1]==1)?true:false;
        if(i>=0 && s3.charAt(k)==s1.charAt(i)){
            boolean res1=helper(s1,s2,s3,i-1,j,k-1);
            memo[i+1][j+1][k+1]=(res1)?1:2;
            if(res1)return true;
        }
        boolean res2=false;
        if(j>=0 && s3.charAt(k)==s2.charAt(j)){
            res2=helper(s1,s2,s3,i,j-1,k-1);
        }
        memo[i+1][j+1][k+1]=(res2)?1:2;
        return res2;
    }
}