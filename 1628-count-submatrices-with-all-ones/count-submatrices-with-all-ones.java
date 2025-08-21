class Solution {
    public int numSubmat(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[] dp=new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1)dp[j]++;
                else dp[j]=0;
                int min=dp[j];
                for(int k=j;k>=0;k--){
                    if(arr[i][k]==0)break;
                    min=Math.min(dp[k],min);
                    ans+=min;
                }
            }
        }
        return ans;
    }
}