class Solution {
    public int largestSubmatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr[j][i]==0){
                    continue;
                }
                arr[j][i]+=arr[j-1][i];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            Arrays.sort(arr[i]);
            // System.out.println(Arrays.toString(arr[i]));
            for(int j=0;j<m;j++){
            // System.out.println(arr[i][j]+" "+arr[i][m-1]);
                ans=Math.max(ans,Math.min(arr[i][j],arr[i][m-1])*(m-j));
            }
        }
        return ans;
    }
}