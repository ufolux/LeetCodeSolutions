package BasicAlgos.dp;

/**
 * DynamicProgramming
 * <p>
 * Q: There's 5 staffs which can be stolen by a thief.
 * name  weight   value
 * 1. guitar   1      1500
 * 2. stereo   4      3000
 * 3. laptop   3      2000
 * 4. iPhone   1      2000
 * 5. Mp3      1      1000
 * <p>
 * But the thief only have a bag with 4 pounds capacity.
 * What is the max value that he could stole and
 * what's the combination of these staffs to achieve the max value.
 */

class Staff {
    int value;
    int weight;

    Staff(int weight, int value) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}

public class DynamicProgramming {
    int calMaxValue(Staff[] staffs, int capacity) {
        int[][] dp = new int[staffs.length][capacity + 1];
        for (int i = 0; i < staffs.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                Staff s = staffs[i];
                if (s.weight <= j) {
                    if (i > 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], s.value + dp[i - 1][j - s.weight]);
                    } else {
                        dp[i][j] = s.value;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[staffs.length - 1][capacity - 1];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        int res = dp.calMaxValue(new Staff[]{
                new Staff(1, 1500),
                new Staff(4, 3000),
                new Staff(3, 2000),
                new Staff(1, 2000),
                new Staff(1, 1000)
        }, 4);
        System.out.println(res);
    }
}
