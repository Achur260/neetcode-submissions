class Solution {
    public int minKnightMoves(int x, int y) {

        if (x == 0 && y == 0) {
            return 0;
        }
        
        int[][] dirs = new int[][] {{1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}, {-1, 2}, {-2, 1}};
        

        boolean[][] seen = new boolean[602][602];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        seen[302][302] = true;
        int step = 0;
        int dx = 1;

        while (dx > 0) {
            dx--;
            int[] curr = queue.remove();
            
            for (int[] dir : dirs) {
                int nextX = curr[0] + dir[0];
                int nextY = curr[1] + dir[1];

                if (nextX == x && nextY == y) {
                    return step+1;
                }

                if (!seen[nextX+301][nextY+301]) {
                    seen[nextX+301][nextY+301] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }


            if (dx == 0) {
                dx = queue.size();
                step++;
            }

        }

        return step;
    }
}
