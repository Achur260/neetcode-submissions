class Solution {
    public int hammingWeight(int n) {
        
        int x = n;


        int count = 0;

        while(x > 0) {
            count+= x%2;
            x = x >> 1;
        }

        return count;
    }
}
