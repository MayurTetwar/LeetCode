class Solution {
    public long mostPoints(int[][] arr) {
        int n=arr.length;
        long[] po=new long[n];
        
        for(int i=n-1;i>=0;i--){
            int ind=i+arr[i][1]+1;
            if(ind<n){
                po[i]=po[ind]+arr[i][0];
            }else{
                po[i]=arr[i][0];
            }
            if(i<n-1){
                po[i]=Math.max(po[i],po[i+1]);
            }
        }
        return po[0];
    }
    /*
    [[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]]
    0 0 0 0 0 0 21 0
    0 0 0 0 0 92 0 0
    0 0 0 0 0 92 0 0
    0 0 0 0 0 92 0 0
    0 0 0 0 0 92 58 0

    0 0 0 0 0 0
    0 1 0 0 2 3
    1 2 3 4 5 9
    */
}
