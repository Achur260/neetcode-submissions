class Solution {
    int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, maxArea(grid, i, j));
                }
            }
        }

        return max;
        
    }


    public int maxArea(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }

        int ans = 1;
        grid[i][j] = 0;

        for (int[] dir : dirs) {
            int newI = dir[0] + i;
            int newJ = dir[1] + j;

            if (isValid(newI,newJ,grid.length, grid[0].length)) {
                ans += maxArea(grid, newI, newJ);
            }
        }

        return ans;


    }
    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
