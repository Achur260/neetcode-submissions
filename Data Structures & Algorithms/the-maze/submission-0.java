class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        


        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        boolean[][] seen = new boolean[maze.length][maze[0].length];

        seen[start[0]][start[1]] = true;


        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!queue.isEmpty()) {

            int[] curr = queue.remove();
            for (int[] direction : directions) {
                int currX = curr[0];
                int currY = curr[1];

                while (isValid(currX + direction[0], currY + direction[1], maze)) {
                    currX += direction[0];
                    currY += direction[1];
                }

                if (currX == destination[0] && currY == destination[1]) {
                    return true;
                }

                if (!seen[currX][currY]) {
                    queue.add(new int[] {currX, currY});
                    seen[currX][currY] = true;
                }
            }
        }


        return false;
    }

    public boolean isValid(int x, int y, int[][] maze) {
        return x > -1 && x < maze.length && y > -1 && y < maze[0].length  && maze[x][y] == 0;
    }
}
