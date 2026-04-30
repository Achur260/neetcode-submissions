class Solution {
    public int reverse(int x) {

        int s = 0;

        int curr = x;
        while (curr != 0) {
            System.out.println(s + " " + curr);
            if (s > Integer.MAX_VALUE/10 || s < Integer.MIN_VALUE/10) {
                return 0;
            }

            s *= 10;
            s += curr % 10;
            curr /= 10;
        }

        return s;
        
    }
}
