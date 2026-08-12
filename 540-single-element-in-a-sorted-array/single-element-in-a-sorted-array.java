class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n=arr.length;
        int st=0;
        int end=n-1;
        while(st<end){
            int mid=st+(end-st)/2;
            if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        if(st==n)return arr[st-1];
        return arr[st];
    }
}