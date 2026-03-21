class Solution {
    public int[][] reverseSubmatrix(int[][] arr, int x, int y, int k) {
        int n=x+k-1;
        for(int i=x;i<n;i++){
            for(int j=y;j<y+k;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[n][j];
                arr[n][j]=temp;
            }
            n--;
        }
        return arr;
    }
}
/*
[[6,16,14]
,[1,2,19]
,[14,17,15]
,[18,7,6]
,[14,12,5]]
 */