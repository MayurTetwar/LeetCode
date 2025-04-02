class Solution {
    public long maximumTripletValue(int[] arr) {
        long ans=0;
        int n=arr.length;
        long imax=0,dmax=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,dmax*arr[i]);
            dmax=Math.max(dmax,imax-arr[i]);
            imax=Math.max(imax,arr[i]);
        }
        return ans;
    }
}