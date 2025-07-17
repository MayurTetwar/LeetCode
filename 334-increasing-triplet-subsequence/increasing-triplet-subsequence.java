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
        int[] right=new int[n];
        for(int i=n-1;i>=0;i--){
            if(max>arr[i]){
                right[i]=max;
            }else{
                right[i]=Integer.MIN_VALUE;
            }
            max=Math.max(arr[i],max);
        }
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        for(int i=0;i<n;i++){
            if(left[i]<arr[i] && arr[i]<right[i]){
                return true;
            }
        }
        return false;
    }
}