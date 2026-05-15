class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int st=0;
        int end=n-1;
        while(st<end){
            int mid=st+(end-st)/2;
            if(arr[mid]<arr[end]){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        return arr[st];
    }
}