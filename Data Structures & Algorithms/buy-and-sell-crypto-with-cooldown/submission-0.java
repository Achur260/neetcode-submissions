class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];

        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;
        for (int i = prices.length - 1; i >= 0; i--) {

            dp[i][0] = Math.max(dp[i+1][0], dp[i+1][1] - prices[i]);

            
            dp[i][1] = Math.max(dp[i+1][1], (i + 2 <= prices.length  ? dp[i+2][0] : 0) + prices[i]);
            
            
        }

        return dp[0][0];
        
    }
}
