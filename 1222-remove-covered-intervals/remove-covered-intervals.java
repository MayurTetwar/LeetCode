class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0])return b[1]-a[1];
            return a[0]-b[0];
        });
        int n=arr.length;
        int curr=0;
        int ans=n;
        for(int i=1;i<n;i++){
            if(arr[curr][0]<=arr[i][1] && arr[i][1]<=arr[curr][1]){
                ans--;
            }else{
                curr=i;
            }
        }
        return ans;
    }
}