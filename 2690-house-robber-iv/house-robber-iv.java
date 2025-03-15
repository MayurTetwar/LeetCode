class Solution {
    public int minCapability(int[] arr, int k) {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        while(min<max){
            int mid=min+(max-min)/2;
            int count=0;
            for(int i=0;i<n;i++){
                if(arr[i]<=mid){
                    i++;
                    count++;
                }
            }
            if(count>=k)max=mid;
            else min=mid+1;
        }
        return min;
    }
}