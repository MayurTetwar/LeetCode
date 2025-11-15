class Solution {
    public int[][] rangeAddQueries(int n, int[][] que) {
        int[][] ans=new int[n][n];
        for(int[] q:que){
            for(int i=q[0];i<=q[2];i++){
                ans[i][q[1]]++;
            }
            if(q[3]+1<n){
                for(int i=q[0];i<=q[2];i++){
                    ans[i][q[3]+1]--;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                ans[i][j]+=ans[i][j-1];
            }
        }
        return ans;
    }
}