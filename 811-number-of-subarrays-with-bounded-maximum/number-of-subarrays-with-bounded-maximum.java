class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
            return helper(arr,right)-helper(arr,left-1);
        }
        public int helper(int[] arr,int num){
            int ans=0;
            int count=0;
            int n=arr.length;
            for(int i=0;i<n;i++){
                if(arr[i]<=num)count++;
                else count=0;
                ans+=count;
            }
            return ans;
        }
}