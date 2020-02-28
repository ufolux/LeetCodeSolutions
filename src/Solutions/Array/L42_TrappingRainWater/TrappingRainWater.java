package Solutions.Array.L42_TrappingRainWater;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n], right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i > 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int v = 0;
        for (int i = 0; i < n; i++) {
            v += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return v;
    }

    public static void main(String[] args) {
        trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3});
    }
}
