package Interviews.Snowflake;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstringCalculator {
    static class TrieNode{
        TrieNode children[];
//        boolean isEnd;

        TrieNode(){
            this.children = new TrieNode[26];
//            this.isEnd = false;
        }
    }

    public static Set<String> seen = new HashSet();

    public static int backtrack(String s, int cnt){
        if(seen.contains(s) || s.length() == 0)
            return 0;

        if(!seen.contains(s))
            seen.add(s.toString());

        if(s.length() == 1)
            return 1;

        return (1 + backtrack(s.substring(0, s.length()-1), cnt)    +
                backtrack(s.substring(1, s.length()), cnt))     +
                backtrack(s.substring(1, s.length()-1), cnt);

    }

    static TrieNode root = new TrieNode();

    public static int distinctSubstringCount(String str){
        //will hold the count of unique substrings
        return backtrack(str, 0);
    }

    public static void main (String[] args) {
        int cnt = distinctSubstringCount("kincenvizh");
        System.out.println("Count of distinct substrings - " + cnt);
    }
}
