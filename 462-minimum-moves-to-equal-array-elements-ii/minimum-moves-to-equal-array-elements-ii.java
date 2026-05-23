class Solution {
    public int minMoves2(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int mid=n/2;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.abs(arr[i]-arr[mid]);
        }
        return ans;
    }
}