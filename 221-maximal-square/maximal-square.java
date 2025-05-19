// File: Solution.java
class Solution {
    public int maximalSquare(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] dp = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((arr[i][j] - '0') == 1) dp[j]++;
                else dp[j] = 0;
            }
            ans = Math.max(ans, helper(dp));
        }
        return ans;
    }

    public int helper(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : arr[i];
            while (!stk.isEmpty() && arr[stk.peek()] >= curr) {
                int height = arr[stk.pop()];
                int width = (stk.isEmpty()) ? i : i - stk.peek() - 1;
                int side = Math.min(height, width);
                ans = Math.max(ans, side * side);
            }
            stk.push(i);
        }
        return ans;
    }
}
