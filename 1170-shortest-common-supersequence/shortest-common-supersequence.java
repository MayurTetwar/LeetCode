class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        // for(int i=0;i<=n;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        StringBuilder sb=new StringBuilder();
        int i=n;
        int j=m;
        while(i>0 && j>0){
            int val=dp[i][j];
            int up=dp[i-1][j];
            int left=dp[i][j-1];
            if(val==up){
                i--;
            }else if(val==left){
                j--;
            }else{
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
        }
        sb=sb.reverse();
        sb.append('@');
        StringBuilder ans=new StringBuilder();
        i=0;
        j=0;
        int k=0;
        while(i<n || j<m){
            while(i<n && str1.charAt(i)!=sb.charAt(k)){
                ans.append(str1.charAt(i++));
            }
            while(j<m && str2.charAt(j)!=sb.charAt(k)){
                ans.append(str2.charAt(j++));
            }
            if(i<n && j<m){
                ans.append(sb.charAt(k++));
                i++;
                j++;
            }
        }
        return ans.toString();
    }
}