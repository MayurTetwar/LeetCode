class Solution {
    public String countOfAtoms(String f) {
        int n = f.length();
        int[] dp = new int[n + 1];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (f.charAt(i) == '(') {
                stk.push(i);
            } else if (f.charAt(i) == ')') {
                dp[stk.pop()] = i;
            }
        }
        HashMap<String, Integer> map = new HashMap<>();
        helper(map, 0, n - 1, 1, f, dp);
        TreeMap<String, Integer> finalMap = new TreeMap<>(map);
        StringBuilder ans = new StringBuilder();
        for (String x : finalMap.keySet()) {
            ans.append(x);
            if (map.get(x) > 1)
                ans.append(map.get(x));
        }
        return ans.toString();
    }

    public void helper(HashMap<String, Integer> map, int st, int end, int add, String f, int[] dp) {
        StringBuilder sb = new StringBuilder();
        while (st <= end) {
            if ('A' <= f.charAt(st) && f.charAt(st) <= 'Z') {
                sb.append(f.charAt(st++));
                while (st <= end && f.charAt(st) >= 'a' && f.charAt(st) <= 'z') {
                    sb.append(f.charAt(st++));
                }
                int val = 0;
                while (st <= end && '0' <= f.charAt(st) && f.charAt(st) <= '9') {
                    val *= 10;
                    val += f.charAt(st++) - '0';
                }
                val = (val == 0) ? 1 : val;
                String x = sb.toString();
                map.put(x, map.getOrDefault(x, 0) + val * add);
                sb = new StringBuilder();
            } else if ('(' == f.charAt(st)) {
                int newst = st + 1;
                int newend = dp[st] - 1;
                int curr = dp[st] + 1;
                int val = 0;
                dp[st] = 0;
                while (curr < f.length() && '0' <= f.charAt(curr) && f.charAt(curr) <= '9') {
                    val *= 10;
                    val += f.charAt(curr) - '0';
                    curr++;
                }
                val = (val == 0) ? 1 : val;
                helper(map, newst, newend, val * add, f, dp);
                st = curr;
            }
        }
    }
}