class Solution {
    public int maxEnvelopes(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return b[1]-a[1];
        });
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=Integer.MIN_VALUE;
        int ans=1;
        for(int i=0;i<n;i++){
            int idx=Arrays.binarySearch(dp,arr[i][1]);
            if(idx<0){
                idx=-idx-1;
            }
            ans=Math.max(ans,idx);
            if(dp[idx]>arr[i][1]){
                dp[idx]=arr[i][1];
            }
        }
        return ans;
    }
}