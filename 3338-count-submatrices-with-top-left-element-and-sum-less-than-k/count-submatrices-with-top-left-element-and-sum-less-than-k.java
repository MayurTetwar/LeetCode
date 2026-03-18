class Solution {
    public int countSubmatrices(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                arr[i][j]+=arr[i][j-1];
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                arr[j][i]+=arr[j-1][i];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]<=k)ans++;
            }
        }
        return ans;
    }
}