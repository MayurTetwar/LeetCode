class Solution {
    public int maxArea(int[] arr) {
        int left=0;
        int right=arr.length-1;
        int max=0;
        while(left<right){
            int high=Math.min(arr[left],arr[right]);
            max=Math.max(max,high*(right-left));
            while(left<right && arr[left]<=high)left++;
            while(left<right && arr[right]<=high)right--;
        }
        return max;
    }
}