class Solution {
    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        if (n % 2 == 0)
            return true;
        return find(nums, 0, n - 1) >= 0;

    }

    static int find(int[] arr, int l, int r) {

        if (l == r)
            return arr[r];

        int ll = arr[l] - find(arr, l + 1, r);
        int rr = arr[r] - find(arr, l, r - 1);

        return (int) Math.max(ll, rr);
    }

}
