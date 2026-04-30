class Solution {
    public int maxA(int n) {
        
        int[] dp = new int[n+1];

        dp[1] = 1;

        for (int i = 1; i <= n; i++) {
            

            dp[i] = Math.max(i, dp[i]);

            for (int j = i + 3; j <= Math.min(n, i+6); j++) {
                dp[j] = Math.max(dp[j], (j-i-1)*dp[i]);
            }
        }

        return dp[n];


    }

    
}
