class Solution {
    public int minimumCost(int[] arr) {
        int n=arr.length;
        int ans=arr[0];
        int ind=-1;
        int max=100;

        for(int i=1;i<n;i++){
            if(max>arr[i]){
                ind=i;
                max=arr[i];
            }
        }
        ans+=max;
        arr[ind]=100;
        max=100;
        for(int i=1;i<n;i++)max=Math.min(max,arr[i]);
        return ans+max;
    }
}