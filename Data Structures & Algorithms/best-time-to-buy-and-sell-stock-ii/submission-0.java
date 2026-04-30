class Solution {
    public int maxProfit(int[] prices) {
        int canBuy = 0;
        int cantBuy = 0;

        for (int i = prices.length-1; i > -1; i--) {
            cantBuy = Math.max(cantBuy, canBuy + prices[i]);
            canBuy = Math.max(canBuy, cantBuy-prices[i]);
        }

        return canBuy;
    }

    public int dp(int[] prices, int i, boolean canBuy) {
        if (i == prices.length) {
            return 0;
        }

        if (canBuy) {
            return Math.max(dp(prices, i+1, canBuy), dp(prices, i, false) - prices[i]);
        } else {
            return Math.max(dp(prices, i+1, canBuy), dp(prices, i+1, true) + prices[i]);
        }


    }
}