class Solution {
    public int minTimeToVisitAllPoints(int[][] arr) {
        int ans=0;
        for(int i=0;i<arr.length-1;i++){
            ans+=Math.max(Math.abs(arr[i+1][0]-arr[i][0]),Math.abs(arr[i+1][1]-arr[i][1]));
        }
        return ans;
    }
}