class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stck = new Stack<>();
        int area = 0;
        for (int i = 0; i <= height.length; i++) {
            while (!stck.isEmpty() && (i == height.length || height[stck.peek()] >= height[i])) {
                int newHeight = height[stck.pop()];
                int width = stck.isEmpty() ? i : i - stck.peek() - 1;
                area = Math.max(area, width * newHeight);
            }
            stck.push(i);
        }
        return area;
    }
}