class Solution {
    public long putMarbles(int[] arr, int k) {
        int n=arr.length;
        long[] temp=new long[n-1];
        for(int i=0;i<n-1;i++){
            temp[i]=arr[i]+arr[i+1];
        }
        Arrays.sort(temp);
        long ans=0;
        for(int i=0;i<k-1;i++){
            ans+=(temp[n-2-i]-temp[i]);
        }
        return ans;
    }
}