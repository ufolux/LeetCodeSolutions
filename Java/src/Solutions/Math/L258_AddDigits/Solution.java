package Solutions.Math.L258_AddDigits;

class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.addDigits(32);
    }
}
