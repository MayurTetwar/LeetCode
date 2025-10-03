class Solution {
    long mod=1000000007;
    public int numberOfGoodSubarraySplits(int[] arr) {
        long ans=1;
        int i=0;
        int n=arr.length;
        while(i<n){
            if(arr[i]==1){
                break;
            }
            i++;
        }
        if(i==n)return 0;
        int left=i;
        i++;
        while(i<n){
            if(arr[i]==1){
                int len=i-left;
                ans=(ans*len)%mod;
                left=i;
            }
            i++;
        }
        return (int)ans;
    }
}