class Solution {
    public int areaOfMaxDiagonal(int[][] arr) {
        Double max=-1.0;
        int ind=-1;
        int n=arr.length;
        for(int i=0;i<n;i++){
            Double len=Math.sqrt(arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1]);
            if(max<=len){
                if(Double.compare(max, len)==0){
                    if(arr[ind][0]*arr[ind][1]<arr[i][0]*arr[i][1]){
                        ind=i;
                    }
                }else{
                    ind=i;
                }
                max=len;
            }
        }
        return arr[ind][0]*arr[ind][1];
    }
}