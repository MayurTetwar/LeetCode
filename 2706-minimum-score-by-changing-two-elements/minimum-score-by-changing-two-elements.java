class Solution {
    public int minimizeSum(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int ans=(int)1e9+7;
        for(int i=0;i<3;i++){
            ans=Math.min(ans,Math.abs(arr[i]-arr[n-3+i]));
        }
        return ans;
    }
}