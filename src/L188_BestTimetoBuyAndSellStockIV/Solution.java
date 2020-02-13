package L188_BestTimetoBuyAndSellStockIV;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int lastSell = 0, lastBuy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            for (int j = 0; j < k; j++) {
                if (j == 0) lastBuy = Math.max(lastBuy, -p);
                else {
                    lastBuy = Math.max(lastBuy, lastSell - p);
                }
                lastSell = Math.max(lastSell, lastBuy + p);
            }
        }
        return lastSell;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxProfit(2, new int[]{3,3,5,0,0,3,1,4});
    }
}