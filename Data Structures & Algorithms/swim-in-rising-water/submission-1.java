class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] dist = new int[n][n];

        for (int [] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }


        dist[0][0] = grid[0][0];

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
            (n1, n2) -> {
                return dist[n1[0]][n1[1]] - dist[n2[0]][n2[1]];
            }
        );

        pq.add(new Integer[] {0, 0});

        int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};

        while (!pq.isEmpty()) {
            Integer[] curr = pq.remove();
            int currX = curr[0];
            int currY = curr[1];

            for (int[] dir : dirs) {
                int newX = currX + dir[0];
                int newY = currY + dir[1];

                if (isValid(newX, newY, n) && Math.max(grid[newX][newY], dist[currX][currY]) < dist[newX][newY]) {
                    dist[newX][newY] = Math.max(grid[newX][newY], dist[currX][currY]);
                    pq.remove(new Integer[] {newX, newY});
                    pq.add(new Integer[] {newX, newY});
                }
            }

        }



        return dist[n-1][n-1];



    }


    private boolean isValid(int x, int y, int n) {

        return x >= 0 && x < n && y >= 0 && y < n;


    }
}
