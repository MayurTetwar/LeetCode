class Solution {
    public int smallestBalancedIndex(int[] arr) {
        int n=arr.length;
        long[] sum=new long[n];
        sum[0]=0;
        long s=arr[0];
        for(int i=1;i<n;i++){
            sum[i]=s;
            s+=arr[i];
        }
        long pro=1;
        int idx=-1;
        for(int i=n-1;i>=0;i--){
            if(pro==sum[i]){
                idx=i;
            }
            if(pro>sum[i]/arr[i])break;
            pro*=arr[i];
        }
        return idx;
    }
}