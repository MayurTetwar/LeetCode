class Solution {
    public int[] corpFlightBookings(int[][] arr, int n) {
        int[] ans=new int[n];
        int m=arr.length;
        for(int i=0;i<m;i++){
            int val=arr[i][2];
            ans[arr[i][0]-1]+=val;
            if(arr[i][1]<n){
                ans[arr[i][1]]-=val;
            }
        }
        for(int i=1;i<n;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}