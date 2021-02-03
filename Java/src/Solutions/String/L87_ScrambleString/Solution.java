package Solutions.String.L87_ScrambleString;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
            // 如果s2中包含s1中没有的字符，false
            int[] letters = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                letters[s1.charAt(i) - 'a']++;
                letters[s2.charAt(i) - 'a']--;
            }
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] != 0)
                    return false;
            }
            //这里的两个if，是因为：满足scramble条件，
            //举个例子：既可以是s1的左子串与s2的左子串匹配&&s1的右子串与s2的右子串匹配；
            //也可以是s1的左子串与s2的右子串匹配&&s1的右子串与s2的左子串匹配
            //所以，既要从s2的前面截取子串与s1左子串进行比较；又要从s2的后面截取子串与s1左子串进行比较
            for (int i = 1; i < s1.length(); i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i))
                        && isScramble(s1.substring(i), s2.substring(i)))
                    return true;
                if (isScramble(s1.substring(0,i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.isScramble("great", "rgeat");
        return;
    }

}
