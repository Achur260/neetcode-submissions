class Solution {
    public int coinChange(int[] coins, int amount) {

    
        int min = Integer.MAX_VALUE;

        for (int coin : coins)
            min = Math.min(min, coin);

        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < amount + 1 - min; i++) {

            if (dp[i] == Long.MAX_VALUE) {
                continue;
            }
            for (int coin : coins) {
                long c = coin;
                if ((long)(i+c) <= (long) amount) {
                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                }
            }
        }
        
        if (dp[amount] == Integer.MAX_VALUE)
            return -1;
        return (int) dp[amount];

        
    }
}
