class Solution {
    public int largestPerimeter(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 3; i >= 0; --i)
            if (arr[i] + arr[i+1] > arr[i+2])
                return arr[i] + arr[i+1] + arr[i+2];
        return 0;
    }
}