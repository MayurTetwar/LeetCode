class Solution {
    public int edgeScore(int[] arr) {
        int n=arr.length;
        long[] count=new long[n];
        for(int i=0;i<n;i++){
            count[arr[i]]+=i;
        }
        long max=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(max<count[i]){
                max=count[i];
                ans=i;
            }
        }
        return ans;
    }
}