package Solutions.Array.L188_BestTimetoBuyAndSellStockIV;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) {
            return 0;
        }

        if (k > prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        int[] buys = new int[k], sells = new int[k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            buys[0] = Math.max(buys[0], -p);
            sells[0] = Math.max(sells[0], buys[0] + p);
            for (int j = 1; j < k; j++) {
                buys[j] = Math.max(buys[j], sells[j - 1] - p);
                sells[j] = Math.max(sells[j], buys[j] + p);
            }
        }
        return sells[sells.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxProfit(2, new int[]{3,3,5,0,0,3,1,4});
    }
}