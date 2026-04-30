class Solution {

    int[] memo;
    public int integerBreak(int n) {
        memo = new int[n+1];
        return helper(n, true);
        
    }

    public int helper(int n, boolean f) {


        if (memo[n] != 0) {
            return memo[n];
        }
        
        int ans = 0;
        if (!f) {
            ans = n;
        }

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, helper(i, false)*helper(n-i, false));
        }

        return memo[n] = ans;

    }
}