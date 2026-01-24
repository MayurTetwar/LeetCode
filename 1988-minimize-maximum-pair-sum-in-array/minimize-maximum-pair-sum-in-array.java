class Solution {
    public int minPairSum(int[] arr) {
        int max=0;
        int n=arr.length;
        Arrays.sort(arr);
        int left=0;
        int right=n-1;
        while(left<right){
            max=Math.max(max,arr[left++]+arr[right--]);
        }
        return max;
    }
}