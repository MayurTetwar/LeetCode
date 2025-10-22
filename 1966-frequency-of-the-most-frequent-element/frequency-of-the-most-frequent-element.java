class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int ans=1;
        long curr=0;
        int j=0;
        for(int i=0;i<n;i++){
            long tar=arr[i];
            curr+=tar;
            while((i-j+1)*tar-curr>k){
                curr-=arr[j];
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}