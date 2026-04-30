class Solution {
    public int reverseBits(int n) {
        int curr = n;
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            int lastDigit = curr & 1;
            rev = rev << 1;
            rev = rev | lastDigit;
            curr = curr >> 1;
        }

        return rev;

    }
}
