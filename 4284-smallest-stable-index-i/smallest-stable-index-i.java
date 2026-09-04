class Solution {
    public int firstStableIndex(int[] arr, int k) {
        int n=arr.length;
        int[] min=new int[n];
        int m=arr[n-1];
        for(int i=n-1;i>=0;i--){
            m=Math.min(m,arr[i]);
            min[i]=m;
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            if(max-min[i]<=k){
                return i;
            }
        }
        return -1;
    }
}