class Solution {
    int[][] memo;
    int total;
    public int lastStoneWeightII(int[] stones) {

        total = 0;
        for (int s : stones) {
            total += s;
        }

        memo = new int[stones.length][2*total + 1];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
 

        return dp(stones, 0, 0);
        
    }

    public int dp(int[] stones, int i, int s) {
        if (i == stones.length) {
            return s;
        } if (memo[i][s+total] != -1) {
            return memo[i][s+total];
        }

        return memo[i][s+total]=Math.min(Math.abs(dp(stones, i + 1, s - stones[i])), Math.abs(dp(stones, i + 1, s + stones[i])));


    }
}