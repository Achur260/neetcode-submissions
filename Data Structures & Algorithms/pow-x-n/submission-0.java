class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / myPow(x, -n);
        }
        double k = myPow(x, n/2);
        double ans = k*k;
        if (n%2 == 1) {
            ans *= x;
        }
        return ans;
        
        
    }
}
