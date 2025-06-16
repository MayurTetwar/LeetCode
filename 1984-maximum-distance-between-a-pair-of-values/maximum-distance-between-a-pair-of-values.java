class Solution {
    public int maxDistance(int[] arr1, int[] arr2) {
        int max=0;
        int n=arr1.length;
        int m=arr2.length;
        // for(int i=0;i<n;i++){
        //     int ind=helper(arr2,i,arr1[i]);
        //     max=Math.max(ind-i,max);
        // }
        int i=0,j=0;
        while(i<n){
            while(j<m && arr1[i]<=arr2[j])j++;
            max=Math.max(max,j-i-1);
            // System.out.println(j+" "+i);
            i++;
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