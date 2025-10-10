class Solution {
    public int maxScore(List<List<Integer>> list) {
        int n=list.size();
        int m=list.get(0).size();
        int[][] dp=new int[n][m];
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i<n-1)dp[i][j]=dp[i+1][j];
                if(j<m-1)dp[i][j]=Math.max(dp[i][j],dp[i][j+1]);
                if(i<n-1 || j<m-1)max=Math.max(max,dp[i][j]-list.get(i).get(j));
                dp[i][j]=Math.max(dp[i][j],list.get(i).get(j));
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return max;
    }
}