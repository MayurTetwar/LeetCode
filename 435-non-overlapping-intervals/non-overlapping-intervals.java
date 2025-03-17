class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for(int i=0;i<arr.length;i++){
            System.out.print(Arrays.toString(arr[i]));
        }
        int n=arr.length;
        int end=arr[0][1];
        int count=0;
        for(int i=1;i<n;i++){
            if(end<=arr[i][0]){
                end=arr[i][1];
            }else count++;
            end=Math.min(arr[i][1],end);
        }
        return count;
    }
}