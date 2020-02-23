package Solutions.L55_JumpGame;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int flag = 0;
                for (; j <= i; j++) {
                    if (nums[j] + j >= nums.length - 1)
                        return true;
                    if (nums[j] + j > i) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        canJump(new int[]{2,5,0,0});
    }
}
