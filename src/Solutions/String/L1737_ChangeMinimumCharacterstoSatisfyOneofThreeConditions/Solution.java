package Solutions.String.L1737_ChangeMinimumCharacterstoSatisfyOneofThreeConditions;

public class Solution {
    public int minCharacters(String a, String b) {
        // using two int arrays to record characters frequency
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c: a.toCharArray()) {
            c1[c-'a']++;
        }
        for (char c: b.toCharArray()) {
            c2[c-'a']++;
        }

        // initialize res
        int m = a.length();
        int n = b.length();
        int res = m + n;

        // 1. make string a and b only consist of distinct character
        for (int i = 0; i < 26; ++i) {
            // means operations to change all characters(m+n) to character i (c1[i] and c2[i])
            res = Math.min(res, m + n - c1[i] - c2[i]);
        }

        // cal prefix sum
        // this prefix sum represents the frequency of all characters less than i;
        for (int i = 1; i < 26; ++i) {
            c1[i] += c1[i - 1];
            c2[i] += c2[i - 1];
        }

        // 2,3 a less than b or b less than a
        // why the up-limit is 25? cos, the character 'z' can not be the base character. there is no one
        for (int i = 0; i < 25; ++i) {
            // c1[i] for freq of characters less than or equal to i in a
            // c2[i] for freq of characters less than or equal to i in b

            // 2. make a < b
            // replace all characters less or equal to i in `b` to larger ones and all characters grater than i in `a` to less ones
            res = Math.min(res, c2[i] + m - c1[i]);
            // 3. make a > b
            // replace all characters less or equal to i in `a` to larger ones and all characters grater than i in `b` to less ones
            res = Math.min(res, c1[i] + n - c2[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int res = s.minCharacters("dabadd", "cda");
        System.out.println(res);
    }
}
