class Solution {
    public int[] countBits(int n) {

        int[] output = new int[n+1];

        output[0] = 0;

        for (int i = 1; i <= n; i++) {
            int count = i%2;
            int x = i >> 1;
            count += output[x];
            output[i] = count;
        }

        return output;

        
    }
}
