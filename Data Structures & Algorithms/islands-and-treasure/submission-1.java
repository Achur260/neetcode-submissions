class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer[]> queue = new LinkedList<>();
        int INF = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    queue.add(new Integer[] {i, j});
            }
        }

        int size = queue.size();
        int step = 1;

        while (size > 0) {
            Integer[] curr = queue.remove();
            size--;

            
            for (int[] dir : dirs) {
                int newX = dir[0] + curr[0];
                int newY = dir[1] + curr[1];
                if (isValid(newX, newY, m, n) && grid[newX][newY] == INF) {
                    queue.add(new Integer[]{newX, newY});
                    grid[newX][newY] = step;
                } 
            }

            if (size == 0) {
                size = queue.size();
                step++;
                System.out.println(step);
                for (Integer[] q: queue) {
                    System.out.println(Arrays.toString(q));
                }
            }


        }
        
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
