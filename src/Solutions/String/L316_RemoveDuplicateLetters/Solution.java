package Solutions.String.L316_RemoveDuplicateLetters;

import java.util.Stack;

class Solution {
    /**
     * Stack Solution
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        int[] smap = new int[26];
        for (int i = 0; i < s.length(); i++)
            map[s.charAt(i) - 'a']++;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (smap[c - 'a'] > 0) {
                map[c - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && map[stack.peek() - 'a'] > 0) {
                char cha = stack.pop();
                smap[cha - 'a']--;
            }

            stack.push(c);
            smap[c - 'a']++;
            map[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c: stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicateLetters("bbcaac");
    }
}
