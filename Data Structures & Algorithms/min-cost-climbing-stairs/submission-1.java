class Solution {

    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);

        return dp(cost, cost.length);
    }

    public int dp(int[] cost, int i) {

        if (i <= -1) {
            return 0;
        } else if (i <= 1) {
            return 0;
        } else if (memo[i] != -1) {
            return memo[i];
        }

        return memo[i] = Math.min(cost[i-1] + dp(cost, i-1), cost[i-2] + dp(cost, i - 2));

        

    }
}
