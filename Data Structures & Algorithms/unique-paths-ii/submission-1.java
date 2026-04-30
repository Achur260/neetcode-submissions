class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        int[] currArr = new int[n];
        currArr[n-1] = 1;

        for (int i = m -1; i >= 0; i--) {
            if (obstacleGrid[i][n-1] == 1) {
                currArr[n-1] = 0;
            }

            for (int j = n - 2; j >= 0; j--) {

                if(obstacleGrid[i][j] == 0)
                    currArr[j] = currArr[j+1] + currArr[j];
                else {
                    currArr[j] = 0;
                }
            }
        }

        return currArr[0];
        
    }
}