class Solution {
    int[][] memo;
    public int minCostII(int[][] costs) {

        memo = new int[costs.length][costs[0].length + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dp(costs, -1, 0);
        
    }

    public int dp(int[][] costs, int prev, int i) {
        if (i == costs.length) {
            return 0;
        }

        if (memo[i][prev+1] != -1) {
            return memo[i][prev+1];
        }


        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < costs[0].length; j++) {
            if (j != prev) {
                ans = Math.min(ans, costs[i][j] + dp(costs, j, i+1));
            }
        }
        return memo[i][prev+1] = ans;
    }
}
