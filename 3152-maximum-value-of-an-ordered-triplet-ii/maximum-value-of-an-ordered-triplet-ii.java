class Solution {
    public long maximumTripletValue(int[] arr) {
        long ans=0,maxd=0,maxi=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,maxd*arr[i]);
            maxd=Math.max(maxd,maxi-arr[i]);
            maxi=Math.max(maxi,arr[i]);
        }
        return ans;
    }
}