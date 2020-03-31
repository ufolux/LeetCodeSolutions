package Solutions.String.L151_ReverseWordsInAString;

import java.util.*;

public class Solution {
    /**
     * Stack Solution
     *
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        if (s.length() == 0) return "";
        s += " ";
        Stack<StringBuffer> stack = new Stack<>();
        StringBuffer res = new StringBuffer("");
        StringBuffer word = new StringBuffer("");
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else if (word.length() != 0) {
                stack.push(word);
                word = new StringBuffer("");
            }
        }
        if (stack.isEmpty()) return "";
        while (stack.size() > 1) {
            res.append(stack.pop().append(" "));
        }
        res.append(stack.pop());
        return res.toString();
    }

    /**
     * Double pointer
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        s += " ";
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0, len = s.length();

        // find the 1st word start and end index

        while (end < len) {
            while (end < len && s.charAt(end) == ' ') {
                end++;
                start = end;
            }
            while (end < len - 1 && s.charAt(++end) != ' ') ;
            for (int i = end; i >= start && end < len && i >= 0; i--) {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == ' ') sb.deleteCharAt(0);
        return sb.reverse().toString();
    }

    public String reverseWords3(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        char[] carr = s.toCharArray();
        int start = 0, end = 0;
        StringBuilder res = new StringBuilder();
        while (end < len) {
            while (end < len && carr[start] == ' ') end = ++start;
            while (end < len && carr[end] != ' ') end++;
            if (start == end) break;
            int i = end - 1;
            while (i >= start) {
                res.append(carr[i--]);
            }
            start = end;
            res.append(' ');
        }
        if (res.length() > 0) res.deleteCharAt(res.length() - 1);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords1("the sky is blue"));
        System.out.println(s.reverseWords2("the sky is blue"));
        System.out.println(s.reverseWords3("  hello world!  "));
        System.out.println(s.reverseWords3("the sky is blue"));
    }
}
