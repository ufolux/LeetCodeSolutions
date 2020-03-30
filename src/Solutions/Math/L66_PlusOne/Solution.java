package Solutions.Math.L66_PlusOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int len = digits.length;
        if (digits[len - 1] + 1 < 10) {
            digits[len - 1]++;
            return digits;
        }
        int ahead = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = (digits[i] + ahead);
            int d = sum % 10;
            res.add(d);
            ahead = sum >= 10 ? 1 : 0;
        }
        if (ahead == 1) res.add(ahead);
        Collections.reverse(res);
        int[] arr = new int[res.size()];
        for (int i=0; i < arr.length; i++) {
            arr[i] = res.get(i).intValue();
        }
        return arr;
    }

    public int[] plusOne2(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i --) {
            if(digits[i] != 9) {
                digits[i] ++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.plusOne(new int[]{8,9,9});
        s.plusOne2(new int[]{8,9,9});
    }
}
