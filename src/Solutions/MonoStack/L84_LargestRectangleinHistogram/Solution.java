package Solutions.MonoStack.L84_LargestRectangleinHistogram;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int cols = heights.length;
        int[] h = new int[cols + 1];
        System.arraycopy(heights, 0, h, 0, heights.length);
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= cols;) {
            // maintain a monotonous increasing stack
            if (st.isEmpty() || h[st.peek()] <= h[i]) {
                st.push(i++);
            } else {
                Integer t = st.pop();
                maxArea = Math.max(maxArea, h[t] * (st.isEmpty() ? i : i - st.peek() - 1));
            }
        }
        return maxArea;
    }
}
