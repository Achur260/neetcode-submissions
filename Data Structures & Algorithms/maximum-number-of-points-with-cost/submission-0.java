class Solution {


    long[][] memo;
    public long maxPoints(int[][] points) {
        memo = new long[points.length][points[0].length];

        for (long[] m : memo) {
            Arrays.fill(m, -1);
        }


        return dp(points, 0, 0);
    }

    public long dp(int[][] points, int i, int j) {
        if (i == points.length){
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        long max = 0;


        if (i == 0) {

            for (int c = 0; c < points[0].length; c++) {
            max = Math.max(max, points[i][c] + dp(points, i+1, c));
        }

        } else {

            for (int c = 0; c < points[0].length; c++) {
            max = Math.max(max, points[i][c] - Math.abs(c-j) + dp(points, i+1, c));
        }

        }


        


        return memo[i][j] = max;
    }
}