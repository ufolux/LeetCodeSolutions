package Solutions.String.L43_MultiplyStrings;

class Solution {
    String add(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        char[] num1c = num1.toCharArray(), num2c = num2.toCharArray();
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1c[i--] - '0' : 0;
            int n2 = j >= 0 ? num2c[j--] - '0' : 0;
            int prod = n1 + n2 + carry;
            int d = prod % 10;
            carry = prod / 10;
            res.append(d);
        }
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    /**
     * 25ms 字符串的常规做法
     * 普通竖式
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply1(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        char[] num1c = num1.toCharArray(), num2c = num2.toCharArray();
        String[] resList = new String[i + 1];
        while (i >= 0) {
            int j = num2.length() - 1;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < num1.length() - i - 1; k++) {
                sb.append('0');
            }
            while (j >= 0) {
                int n1 = num1c[i] - '0';
                int n2 = num2c[j--] - '0';
                int prod = n1 * n2 + carry;
                int d = prod % 10;
                carry = prod / 10;
                sb.append(d);
            }
            if (carry > 0) {
                sb.append(carry);
            }
            resList[i--] = sb.reverse().toString();
        }

        String sum = "";
        for (String s : resList) {
            sum = add(sum, s);
        }
        return sum;
    }

    /**
     * 3ms
     * 用数组来保存每一位的计算结果，最后统一处理进位
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        char[] num1arr = (new StringBuilder(num1)).reverse().toString().toCharArray();
        char[] num2arr = (new StringBuilder(num2)).reverse().toString().toCharArray();
        int len1 = num1arr.length, len2 = num2arr.length;
        int[] res = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                res[j + i] += (num1arr[i] - '0') * (num2arr[j] - '0');
            }
        }

        for (int i = 0; i < len1 + len2; i++) {
            int d = res[i];
            if (d > 9) {
                res[i] = d % 10;
                res[i + 1] += d /10;
            }
        }
        int pos = res[len1 + len2 - 1] == 0 ? len1 + len2 - 2 : len1 + len2 - 1;
        StringBuilder aa = new StringBuilder();
        for (;pos >= 0; --pos) {
            aa.append(res[pos]);
        }
        return aa.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.multiply1("123", "456");
        s.multiply2("123", "456");
    }
}
