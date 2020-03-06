package Solutions.Array.L244_ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;

public class WordDistance {
    private HashMap<String, ArrayList<Integer>> wordsMap = new HashMap<String, ArrayList<Integer>>();

    private void preProcess (String[] words) {
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (wordsMap.get(s) == null) {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(i);
                wordsMap.put(s, a);
            } else {
                ArrayList<Integer> a = wordsMap.get(s);
                a.add(i);
            }
        }
    }

    public WordDistance(String[] words) {
        this.preProcess(words);
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> a1 = wordsMap.get(word1);
        ArrayList<Integer> a2 = wordsMap.get(word2);


            int min = Integer.MAX_VALUE;

            for (Integer value : a1) {
                for (Integer integer : a2) {
                    if (Math.abs(value - integer) < min)
                        min = Math.abs(value - integer);
                }
            }
            return min;
    }

    public static void main(String[] args) {
        WordDistance a = new WordDistance(new String[]{"a","c","b","b","a"});
        a.shortest("a", "b");
    }
}

