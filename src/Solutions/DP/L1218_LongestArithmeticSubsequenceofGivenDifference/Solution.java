package Solutions.DP.L1218_LongestArithmeticSubsequenceofGivenDifference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    int longestSubsequence(List<Integer> arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxCounter = 1;
        for (Integer integer : arr) {
            dp.put(integer, Math.max(dp.get(integer), dp.get(integer - difference) + 1));
            maxCounter = Math.max(maxCounter, dp.get(integer));
        }
        return maxCounter;
    }
}
