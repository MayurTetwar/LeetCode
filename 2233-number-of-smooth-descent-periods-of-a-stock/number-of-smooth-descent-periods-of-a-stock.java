class Solution {
    public long getDescentPeriods(int[] arr) {
        long ans=0;
        int n=arr.length;
        int count=0;
        for(int i=n-2;i>=0;i--){
            if(arr[i]-arr[i+1]==1){
                count++;
            }else{
                count=0;
            }
            ans+=count;
        }
        return ans+n;
    }
}