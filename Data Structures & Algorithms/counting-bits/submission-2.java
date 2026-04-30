class Solution {
    public int[] countBits(int n) {

        int[] output = new int[n+1];

        output[0] = 0;

        for (int i = 1; i <= n; i++) {
            output[i] = (i & 1) + output[i >> 1];
        }

        return output;

        
    }
}
