class Solution {
    public int smallestDistancePair(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int st=0,end=arr[n-1]-arr[0];
        while(st<end){
            int mid=st+(end-st)/2;
            if(helper(arr,mid,k)){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        return st;
    }
    public boolean helper(int[] arr,int mid,int k){
        int st=0;
        int count=0;
        for(int end=0;end<arr.length;end++){
            while(arr[end]-arr[st]>mid)st++;
            count+=(end-st);
            if(count>=k)return true;
        }
        return false;
    }
}