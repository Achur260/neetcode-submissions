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

}