class Solution {
    public long maxPower(int[] nums, int r, int k) {
        long st=0;
        long end=0;
        long[] arr=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            end+=nums[i];
            arr[i]=nums[i];
        }
        end+=k+1;
        long ans=0;
        while(st<end){
            long mid=st+(end-st)/2;
            if(helper(arr.clone(),r,k,mid)){
                st=mid+1;
                ans=mid;
            }else{
                end=mid;
            }
                // System.out.println("-----------------");
        }
        return ans;
    }
    public boolean helper(long[] arr,int r,int k,long mid){
        int n=arr.length;
        long curr=0;
        for(int i=0;i<r;i++)curr+=arr[i];
        for(int i=0;i<n;i++){
            int left=i-r-1;
            int right=i+r;
            if(left>=0)curr-=arr[left];
            if(right<n)curr+=arr[right];
            if(curr<mid){
                k-=(mid-curr);
                arr[Math.min(n-1,right)]+=(mid-curr);
                curr=mid;
            }
            if(k<0)return false;
        }
        // System.out.println(Arrays.toString(arr)+" "+mid);
        return true;
    }
}