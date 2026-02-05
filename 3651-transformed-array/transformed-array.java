class Solution {
    public int[] constructTransformedArray(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=arr[((((i+arr[i])%n)+n)%n)];
        }
        return ans;
    }
}