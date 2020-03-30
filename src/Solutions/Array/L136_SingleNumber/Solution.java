package Solutions.Array.L136_SingleNumber;

public class Solution {
    /**
     * a^0 = a
     * a^a = 0
     * a^b^a = a^a^b = 0^b = b
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int x: nums) {
            sum ^= x;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.singleNumber(new int[]{2,3,2,4,3,4,1,5,6,5,6});
    }
}