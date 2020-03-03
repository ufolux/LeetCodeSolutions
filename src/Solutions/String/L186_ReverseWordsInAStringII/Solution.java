package Solutions.String.L186_ReverseWordsInAStringII;

import javafx.scene.control.skin.SliderSkin;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        int start = 0, end = 0, len = s.length;

        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }


        while (end < len) {
            while (end < len && s[end] == ' ') {
                end++;
                start = end;
            }
            while (end < len) {
                end++;
                if (end == len) break;
                else if (s[end] != ' ') continue;
                else break;
            }
            int limit = (end + start) / 2;
            for (int i = end - 1; i >= limit; i--) {
                int j = end - 1 - i + start;
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] arr = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        s.reverseWords(arr);
        System.out.println(new String(arr));
    }
}
