class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int[] suff=new int[n];
        int max=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.max(suff[i+1],max-arr[i]);
            max=Math.max(max,arr[i]);
        }
        int ans=0;
        int min=arr[0];
        for(int i=1;i<n;i++){
            ans=Math.max(ans,arr[i]-min+suff[i]);
            min=Math.min(min,arr[i]);
        }
        return ans;
    }
}