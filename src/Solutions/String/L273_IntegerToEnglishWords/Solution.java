package Solutions.String.L273_IntegerToEnglishWords;

class Solution {
    public String numberToWords(int num) {
        int[] values = {
                1000000000, 1000000,
                1000, 100, 10, 1
        };
        String[] names = {
                "Billion", "Million", "Thousand", "Hundred", "TenDigit", ""
        };

        String[] tens = {
                "", "", "", "", "", "", "", "", "", "",
                "Ten", "Eleven", "Twelve", "Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"
        };

        String[] tenNumbers = {
                "", "", "Twenty", "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        String[] numbers = {
                "", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine"
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int cnt = 0;
            if (num >= 100) {
                while (num >= values[i]) {
                    num -= values[i];
                    cnt++;
                }
                if (cnt > 0) {
                    sb.append(numbers[cnt]);
                    sb.append(" ");
                    sb.append(names[i]);
                    sb.append(" ");
                }
            } else {
                if (num < 20 && num >= 10) {
                    sb.append(tens[num]);
                } else if (num >= 20) {
                    sb.append(tenNumbers[num / 10]);
                    sb.append(" ");
                    sb.append(numbers[num % 10]);
                } else {
                    sb.append(numbers[num]);
                }
                num = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 20; i++) {
            System.out.println(s.numberToWords(12345 + i));
        }
    }
}
