class Solution {


    public int numSquares(int n) {
        

        int[] memo = new int[n+1];

        for (int i = 1; i <= n; i++) {
            
            int val = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++) {
                val = Math.min(val, memo[i-j*j]);
            }

            memo[i]=val+1;
        }

        return memo[n];
    }


}