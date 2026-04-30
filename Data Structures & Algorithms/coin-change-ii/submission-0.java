class Solution {

    int[][] memo;
    public int change(int amount, int[] coins) {
        
        memo = new int[amount + 1][coins.length];
        
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dp(amount, coins, 0);

    }

    public int dp(int amount, int[] coins, int i) {

        if (amount < 0) {
            return 0;
        } else if (amount == 0) {
            return 1;
        } else if (i == coins.length) {
            return 0;
            
        } else if (memo[amount][i] != -1) {
            return memo[amount][i];
        }

        int ans = 0;

        for (int j = i; j < coins.length; j++) {
            ans += dp(amount - coins[j], coins, j);
        }

        return memo[amount][i] = ans;

    }
}
