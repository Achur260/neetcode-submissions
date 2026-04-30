class Solution {
    int[][] memo;
    int[] sums;
    public int stoneGameII(int[] piles) {

        memo = new int[piles.length][piles.length+1];

        for (int[] m : memo) {
            Arrays.fill(m,-1);
        }

        sums = new int[piles.length+1];

        sums[piles.length] = 0;

        for(int i = piles.length -1; i >= 0; i--) {
            sums[i] = sums[i+1] + piles[i];
        }

        return dp(piles, 0, 1);
        
    }

    public int dp(int[] piles, int i, int M) {

        if (i >= piles.length) {
            return 0;
        } else if (memo[i][M] != -1) {
            return memo[i][M];
        }

        int sum = 0;
        int ans = 0;

        for (int size = 1; size <= 2*M; size++) {
            int currIndex = size + i - 1;
            if (currIndex >= piles.length) {
                break;
            }

            sum += piles[currIndex];
            int opSum = dp(piles, currIndex + 1, Math.max(M, size));
            ans = Math.max(ans, sum + (sums[currIndex+1] - opSum));

        }


        return memo[i][M] = ans;

        
    }
}