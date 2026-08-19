class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int cool = 0;

        for (int i = 1; i < prices.length; i++) {
            int oldBuy = buy;
            int oldSell = sell;

            buy = Math.max(buy, cool - prices[i]);
            sell = Math.max(sell, oldBuy + prices[i]);
            cool = Math.max(cool, oldSell);
        }

        return sell;
    }
}