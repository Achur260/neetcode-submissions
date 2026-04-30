class Solution {
    public int numWays(int n, int k) {

        if (n == 1) {
            return k;
        }

        if (n == 2) {
            return k*k;
        }

        int same = k;
        int diff = k*(k-1);

        for (int i = 2; i < n; i++) {
            int tSame = same;
            int tDiff = diff;
            same = tDiff;
            diff = (k-1)*(tSame + tDiff);
        }

        return same + diff;
        
    }
}
