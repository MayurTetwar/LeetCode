class Solution {
    public int[][] constructProductMatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        long mod=12345;
        long[] pre=new long[n*m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pre[i*m+j]=arr[i][j];
            }
        }
        long[] suff=pre.clone();
        for(int i=1;i<n*m;i++){
            pre[i]=(pre[i-1]*pre[i])%mod;
        }
        for(int i=n*m-2;i>=0;i--){
            suff[i]=(suff[i+1]*suff[i])%mod;
        }
        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(suff));

        long[] flat=new long[n*m];
        flat[0]=(suff[1])%mod;
        for(int i=1;i<n*m-1;i++){
            flat[i]=(pre[i-1]*suff[i+1])%mod;
        }
        flat[n*m-1]=(pre[n*m-2])%mod;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=(int)flat[i*m+j];
            }
        }
        return ans;
    }
}