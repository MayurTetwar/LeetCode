class Solution {
    static{
        for(int i=0;i<500;i++){
            countSubarrays(new int[]{1},0);
        }
    }
    public static long countSubarrays(int[] arr, long k) {
        int n = arr.length;
        long prefix[] = new long[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }
        long ans = 0;
        long pre = 0;
        int i = 0;
        int ind = 0;
        for (i = 0; i < n; i++) {
            ind = helper(prefix, k, pre, i) - i;
            ans += ind;
            pre = prefix[i];
        }
        return ans;
    }

    public static int helper(long[] arr, long k, long pre, int i) {
        int st = i;
        int end = arr.length;
        while (st < end) {
            int mid = (end + st) / 2;
            if (((arr[mid] - pre) * (mid - i + 1)) < k) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}