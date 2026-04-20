class Solution {
    public int maxDistance(int[] arr) {
        int max=0;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[0]){
                max=Math.max(max,i);
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]!=arr[n-1]){
                max=Math.max(max,n-i-1);
            }
        }
        return max;
    }
}