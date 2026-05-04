class Solution {
    public void rotate(int[][] arr) {
        int n=arr.length;
        for(int k=0;k<n;k++){
            int i=0,j=n-1;
            while(i<j){
                int temp=arr[i][k];
                arr[i][k]=arr[j][k];
                arr[j][k]=temp;
                i++;
                j--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
}