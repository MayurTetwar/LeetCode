class Solution {
    public int minimumDifference(int[] arr, int k) {
        int min=Integer.MAX_VALUE;
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i+k-1<n;i++){
            min=Math.min(min,arr[i+k-1]-arr[i]);
        }
        return min;
    }
}