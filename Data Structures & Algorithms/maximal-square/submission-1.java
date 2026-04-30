class Solution {
    int[][] memo;
    public int maximalSquare(char[][] matrix) {

        memo = new int[matrix.length][matrix[0].length];

        for (int[] m : memo) {
            Arrays.fill(m,-1);
        }

        int max = 0;

        for (int i  = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dp(matrix, i, j));
            }
        }


        return max*max;
    }

    public int dp(char[][] matrix, int i, int j) {
        if (j >= matrix[0].length || i >= matrix.length) {
            return 0;
        }    

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (matrix[i][j] == '0') {
            return 0;
        }

        int down = dp(matrix, i+1, j);
        int right = dp(matrix, i, j+1);
        int diag = dp(matrix, i+1, j+1);

        int minimum = Math.min(down, Math.min(right, diag));

        return memo[i][j] = 1 + minimum;
    }
}