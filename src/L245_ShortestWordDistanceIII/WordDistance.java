package L245_ShortestWordDistanceIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
    public static int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, ans = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                idx1 = i;
                if(idx2 >= 0) {
                    ans = Math.min(ans, idx1 - idx2);
                }
            }
            if(words[i].equals(word2)) {
                idx2 = i;
                if(idx1 >= 0 && idx1 != idx2) {
                    ans = Math.min(ans, idx2 - idx1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        shortestWordDistance(new String[]{"a","c","b","b","a"}, "a", "b");
    }
}

