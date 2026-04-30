class Solution {
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dp(matrix, i, j));
            }
        }


        return max;
    }


    public int dp(int[][] matrix, int i, int j) {

        
        int ans = 0;

        for (int[] dir : dirs) {
            int newX = dir[0] + i;
            int newY = dir[1] + j;

            if (isValid(newX, newY, matrix.length, matrix[0].length) && matrix[newX][newY] > matrix[i][j])
                ans = Math.max(ans, dp(matrix, newX, newY));
            
        }

        return 1 + ans;
    } 

    public boolean isValid(int i, int j, int m, int n) {
        return i > -1 && j > -1 && i < m && j < n;
    }
}
