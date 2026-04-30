class Solution {
    public int islandPerimeter(int[][] grid) {

        int perim = 0;

        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[][] directions = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};



        while (!queue.isEmpty()) {
            int[] curr = queue.remove();

            for (int[] dir : directions) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];

                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == 0) {
                    perim+=1;
                } else if (grid[newX][newY] != -1){
                    grid[newX][newY] = -1;
                    queue.add(new int[]{newX, newY});
                }
            }
            
        }


        return perim;
        
    }
}