class Solution {

    int[][] memo;
    public int minCost(int[][] costs) {
        memo = new int[costs.length][3];


        return dp(costs, -1, 0);
        
    }

    public int dp(int[][] costs, int prev, int index) {

        if (index == costs.length) {
            return 0;
        }

        if (prev > -1 && memo[index][prev] != 0) {
            return memo[index][prev];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (i != prev) {
                ans = Math.min(ans, costs[index][i] + dp(costs, i, index+1));
            }
        }

        if (prev != -1) {
            memo[index][prev] = ans;
        }
        return ans;
    }
}