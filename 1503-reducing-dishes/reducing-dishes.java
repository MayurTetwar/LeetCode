class Solution {
    public int maxSatisfaction(int[] arr) {
        int ans=0;
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int mul=1;
            int curr=0;
            for(int j=i;j<n;j++){
                curr+=arr[j]*mul;
                mul++;
            }
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}