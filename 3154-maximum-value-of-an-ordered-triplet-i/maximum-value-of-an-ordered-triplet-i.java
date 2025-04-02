class Solution {
    public long maximumTripletValue(int[] arr) {
        long ans=0;
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            while(j<n-1){
                for(int k=j+1;k<n;k++){
                    ans=Math.max(ans,(arr[i]-arr[j])*(long)arr[k]);
                }
                j++;
            }
        }
        return ans;
    }
}