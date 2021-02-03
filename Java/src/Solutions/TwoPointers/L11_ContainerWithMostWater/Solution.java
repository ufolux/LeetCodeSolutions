package Solutions.TwoPointers.L11_ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0, j = len - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) --j;
            else ++i;
        }
        return maxArea;
    }
}
