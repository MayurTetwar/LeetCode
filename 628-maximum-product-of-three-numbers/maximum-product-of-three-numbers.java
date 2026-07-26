class Solution {
    public int maximumProduct(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        return Math.max(arr[n-1]*arr[0]*arr[1],arr[n-1]*arr[n-2]*arr[n-3]);
    }
}