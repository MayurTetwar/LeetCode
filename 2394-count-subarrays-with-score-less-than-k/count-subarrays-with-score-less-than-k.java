class Solution {
    public long countSubarrays(int[] arr, long k) {
        long ans=0;
        int n=arr.length;
        int j=0;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(j<i && sum*(i-j+1)>=k){
                sum-=arr[j];
                j++;
            }
            if(sum*(i-j+1)<k)ans+=(i-j+1);
        }
        return ans;
    }
}