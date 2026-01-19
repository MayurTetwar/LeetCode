class Solution {
    public int maxSideLength(int[][] arr, int threshold) {
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
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int k=i,p=j;
                while(k<n && p<m){
                    int sum=0;
                    sum+=arr[k][p];
                    sum-=(i==0)?0:arr[i-1][p];
                    sum-=(j==0)?0:arr[k][j-1];
                    sum+=(i==0 || j==0)?0:arr[i-1][j-1];
                    if(sum>threshold)break;
                    max=Math.max(max,k-i+1);
                    k++;
                    p++;
                }
            }
        }
        return max;
    }
}