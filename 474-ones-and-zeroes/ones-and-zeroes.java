class Solution {
    int[][][] dp;
    public int findMaxForm(String[] s, int m, int n) {
        int len=s.length;
        int[] count=new int[len];
        int[] size=new int[len];
        dp=new int[n+1][m+1][len];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int i=0;
        for(String str:s){
            for(char ch:str.toCharArray()){
                if(ch=='0')count[i]++;
            }
            size[i]=str.length();
            i++;
        }
        return helper(count,size,0,n,m);
        //return Math.max(ans,1);
    }
    public int helper(int[] count,int[] size,int i,int n,int m){
        if(i==count.length)return 0;
        if(dp[n][m][i]!=-1)return dp[n][m][i];

        if(size[i]-count[i]<=n && count[i]<=m){
            int ans1=1+helper(count,size,i+1,n-size[i]+count[i],m-count[i]);
            int ans2=helper(count,size,i+1,n,m);
            return dp[n][m][i]=Math.max(ans1,ans2);
        }else{
            return  dp[n][m][i]=helper(count,size,i+1,n,m);
        }
    }
}