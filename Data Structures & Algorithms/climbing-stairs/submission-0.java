class Solution {
    public int climbStairs(int n) {

        if (n <= 1) {
            return n;
        }

        int before = 1;
        int preBefore = 1;

        for (int i = 2; i <= n; i++) {
            int sum = before + preBefore;
            preBefore = before;
            before = sum;
        }


        return before;
        
    }
}
