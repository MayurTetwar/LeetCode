class Solution {
    public boolean areSimilar(int[][] arr,int k) {
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            int right=0;
            if(i%2==0){
                right=m-k%m-(k%m==0?m:0);
            }else{
                right=k%m;
            }
            for(int j=0;j<m;j++){
                if(arr[i][j]!=arr[i][right]){
                    return false;
                }
                right++;
                right=(right%m);
            }
        }
        return true;
    }
}