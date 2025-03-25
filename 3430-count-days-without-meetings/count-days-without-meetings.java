class Solution {
    public static int countDays(int days, int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int start=0;
        int end=0;
        int ans=days;
        for(int i=1;i<n;i++){
            if(arr[end][1]<arr[i][0]){
                ans-=(arr[end][1]-arr[start][0])+1;
                start=i;
            }
            end=(arr[end][1]>arr[i][1])?end:i;
        }
        ans-=(arr[end][1]-arr[start][0])+1;
        return ans;
    }
}