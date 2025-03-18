class Solution {
    public int longestNiceSubarray(int[] arr) {
        int n=arr.length;
        int max=0;
        int ans=arr[0];
        int j=0;
        for(int i=1;i<n;i++){
            while((ans & arr[i])!=0){
                ans^=arr[j++];
            }
            ans|=arr[i];
            max=Math.max(max,i-j);
        }
        return max+1;
    }
}