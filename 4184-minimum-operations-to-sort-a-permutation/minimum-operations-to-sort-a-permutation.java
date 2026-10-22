class Solution {
    public int minOperations(int[] arr) {
        int count=0;
        int n=arr.length;
        int min=arr[0];
        int idx=0;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i])count++;
            if(min>arr[i]){
                min=arr[i];
                idx=i;
            }
        }
        if(arr[n-1]>arr[0])count++;
        if(count<2){
            return Math.min(idx,n-idx+2);
        }

        count=0;
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i])count++;
        }
        if(arr[n-1]<arr[0])count++;
        if(count<2){
            if(idx<n/2)return idx+2;
            return n-idx;
        }
        return -1;
    }
}