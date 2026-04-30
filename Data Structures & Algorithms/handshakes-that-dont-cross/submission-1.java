class Solution {

    long[] dp;
    public int numberOfWays(int numPeople) {
        dp = new long[numPeople+1];

        Arrays.fill(dp, -1);
        return (int) helper(numPeople);
        
    }

    public long helper (int numPeople) {
        if (numPeople <= 2)
            return 1;
        if (dp[numPeople] != -1) {
            return dp[numPeople];
        }
        
        long ans = 0;

        for (int x = 0; x <= numPeople - 2; x+=2) {
            ans += (helper(x)*helper(numPeople-2-x)) % 1000000007;
        }

        return dp[numPeople] = ans % 1000000007;

    }
}
