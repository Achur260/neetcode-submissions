class Solution {

    double[] memo;
    public double new21Game(int n, int k, int maxPts) {
        memo = new double[n+1];
        Arrays.fill(memo, -1);
        return helper(n, k, maxPts);
    }

    public double helper(int n, int k, int maxPts) {

        if (k <= 0) {
            return n >= 0 ? 1 : 0;
        }

        if (memo[n] != -1)  {
            return memo[n];
        }

        double ans = 0;
        double mpts = maxPts;

        for (int i = 1; i <= maxPts; i++) {
            ans += helper(n-i, k-i, maxPts);
        }

        ans /= mpts;

        return memo[n]=ans;
    }

    
}