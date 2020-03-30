package Solutions.String.L273_IntegerToEnglishWords;

import java.util.Spliterator;

public class Solution {
    String[] tenNumbers = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] numbers = {
            "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
    };

    String getHundred (int num) {
        StringBuilder sb = new StringBuilder();
        int h = num / 100;
        num -= h * 100;
        int t = num / 10;
        t = t > 1 ? t : 0;
        num -= t * 10;
        int d = num;
        if (h > 19) {
            int twoDigit = h / 10;
            h -= twoDigit * 10;
            sb.append(tenNumbers[twoDigit]).append(" Hundred ").append(numbers[h]).append(" ");
        } else if (h > 0) {
            sb.append(numbers[h]).append(" Hundred ");
        }
        if (t > 0) sb.append(tenNumbers[t]).append(" ");
        if (d > 0) sb.append(numbers[d]).append(" ");
        return sb.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        // Billion
        int b = num / 1000000000;
        num -= b * 1000000000;
        if(b > 0) sb.append(getHundred(b)).append("Billion ");
        // Million
        int m = num / 1000000;
        num -= m * 1000000;
        if(m > 0) sb.append(getHundred(m)).append("Million ");
        // Thousand
        int t = num / 1000;
        num -= t * 1000;
        if(t > 0) sb.append(getHundred(t)).append("Thousand ");
        // Hundred
        if (num > 0) sb.append(getHundred(num));
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numberToWords(1234567891);
        s.numberToWords(1000000000);
        s.numberToWords(1200000000);
        s.numberToWords(12000000);
        s.numberToWords(12000);
        s.numberToWords(123);
        s.numberToWords(12);
        s.numberToWords(1);
    }
}
