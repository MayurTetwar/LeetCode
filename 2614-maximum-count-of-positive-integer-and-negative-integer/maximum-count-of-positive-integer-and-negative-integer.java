class Solution {
    public int maximumCount(int[] arr) {
        int start=0;
        int n=arr.length;
        int end=n-1;
        int ans1=0,ans2=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<0){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        ans1=start;
        start=0;
        end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=0){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return Math.max(ans1,n-start);
    }
}