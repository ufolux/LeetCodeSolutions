package Solutions.Math.L67_AddBinary;

public class Solution {
    String addBinary (String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int da = i >= 0 ? a.charAt(i--) - '0' : 0;
            int db = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = (da + db + carry) % 2;
            carry = (da + db + carry) >> 1;
            sb.append(sum);
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1001", "101"));
    }
}
