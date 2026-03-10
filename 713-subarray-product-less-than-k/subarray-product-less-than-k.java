class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int ans=0;
        long pro=1;
        int j=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            pro*=arr[i];
            while(j<i && pro>=k){
                pro/=arr[j];
                j++;
            }
            if(pro<k)ans+=(i-j+1);
        }
        return ans;
    }
}