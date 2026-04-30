class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});

                }
            }
        }


        if (count == 0) {
            return 0;
        }

        

        int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int step = 0;
        int size = q.size();

        while(size > 0) {
            
            int[] curr = q.remove();
            size--;
            if (count == 0) {
            return step;
        }

            for (int[] dir : dirs) {
                int newX = dir[0] + curr[0];
                int newY = dir[1] + curr[1];
                

                if (isValid(newX, newY, m, n) && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    count--;
                    q.add(new int[] {newX, newY});
                }
            }

            if (count == 0) {
                    return step+1;
                }


            

            if (size == 0) {
                size = q.size();
                if (count == 0) {
                    return step+1;
                }
                step++;
            }
        }



        return -1;

        
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
