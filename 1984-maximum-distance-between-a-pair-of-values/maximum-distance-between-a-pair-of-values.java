class Solution {
    public int maxDistance(int[] arr1, int[] arr2) {
        int max=0;
        int n=arr1.length;
        for(int i=0;i<n;i++){
            int ind=helper(arr2,i,arr1[i]);
            max=Math.max(ind-i,max);
        }
        return max;
    }
    public int helper(int[] arr,int i,int tar){
        int st=i,end=arr.length-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]<tar){
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return end;
    }
}