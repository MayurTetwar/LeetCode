class Solution {
    public int[] corpFlightBookings(int[][] arr, int n) {
        int[] ans=new int[n];
        int m=arr.length;
        for(int i=0;i<m;i++){
            for(int j=arr[i][0]-1;j<arr[i][1];j++){
                ans[j]+=arr[i][2];
            }
        }
        return ans;
    }
}