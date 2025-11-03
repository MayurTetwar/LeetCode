class Solution {
    public int minCost(String col, int[] arr) {
        int n=arr.length;
        int ans=0;
        int i=0;
        while(i<n){
            char ch=col.charAt(i);
            int sum=0;
            int max=0;
            while(i<n && ch==col.charAt(i)){
                sum+=arr[i];
                max=Math.max(max,arr[i]);
                i++;
            }
            ans+=(sum-max);
        }
        return ans;
    }
}