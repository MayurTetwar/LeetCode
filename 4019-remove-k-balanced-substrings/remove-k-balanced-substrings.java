class Solution {
    public String removeSubstring(String a, int b) {
        StringBuilder x = new StringBuilder();
        String y = "(".repeat(b) + ")".repeat(b);
        int i = 0;
        for (; i < a.length();) {
            x.append(a.charAt(i++));
            if (x.length() >= 2 * b) {
                int j = x.length() - 2 * b;
                String z = x.substring(j);
                if (z.equals(y)) x.delete(j, x.length());
            }
        }
        return x.toString();
    }
}