class Solution {
    public int maxProfit(int[] prices) {
        
        int start = 0;
        int end = 0;

        int maxP = 0;

        while (end < prices.length) {
            if (start == end) {
                end++; 
            
            } else {
                if (prices[end] <= prices[start]) {
                    maxP = Math.max(maxP, prices[end] - prices[start]);
                    start++;
                } else {
                    maxP = Math.max(maxP, prices[end] - prices[start]);
                    end++;
                }
            }
        }


        return maxP;
    }
}
