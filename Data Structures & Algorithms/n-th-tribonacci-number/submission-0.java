class Solution {
    public int tribonacci(int n) {

        if (n <= 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        int one = 0;
        int two = 1;
        int three = 1;
        
        for (int i = 3; i <= n; i++) {
            int sum = one+two+three;


            one = two;
            two = three;
            three = sum;
        }

        return three;
        
    }
}