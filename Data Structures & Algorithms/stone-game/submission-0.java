class Solution {


    public boolean stoneGame(int[] piles) {

        int[][] dp = new int[piles.length][piles.length];

        for(int size = 1; size <= piles.length; size++) {
            for (int i = 0; i <= piles.length - size; i++) {
                if (size == 1) {
                    dp[i][i+size-1] = piles[i];
                } else {
                    dp[i][i+size-1] = Math.max(piles[i] - dp[i+1][i+size-1], piles[i+size-1] - dp[i][i+size-2]);
                }
            }
        }

        return dp[0][piles.length-1] > 0;
        
        
    }

}