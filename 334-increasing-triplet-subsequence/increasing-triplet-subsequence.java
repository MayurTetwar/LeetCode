class Solution {
    public boolean increasingTriplet(int[] arr) {
        int n=arr.length;
        int min=arr[0];
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            if(min<arr[i]){
                left[i]=min;
            }else{
                left[i]=Integer.MAX_VALUE;
            }
            min=Math.min(arr[i],min);
        }
        int max=arr[n-1];
        for(int i=n-1;i>=0;i--){
            max=Math.max(arr[i],max);
            if(left[i]<arr[i] && arr[i]<max){
                return true;
            }
        }
        return false;
    }
}