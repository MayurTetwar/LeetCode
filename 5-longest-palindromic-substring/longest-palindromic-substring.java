class Solution {
    public String longestPalindrome(String s) {
        return longestPalindrome2(s);
    }
    public String longestPalindrome2(String s) {
        // Preprocess
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) sb.append("#").append(c);
        sb.append("#$");
        String t = sb.toString();
        int n = t.length();
        int[] P = new int[n];
        int C = 0, R = 0;

        for (int i = 1; i < n - 1; i++) {
            int mirr = 2 * C - i; // mirror of i around C

            if (i < R) P[i] = Math.min(R - i, P[mirr]);

            // Expand palindrome centered at i
            while (t.charAt(i + (1 + P[i])) == t.charAt(i - (1 + P[i]))) P[i]++;

            // Update C and R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // Find max palindrome
        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}