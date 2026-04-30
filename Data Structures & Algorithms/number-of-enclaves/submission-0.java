class Solution {
    public int numEnclaves(int[][] grid) {

        boolean[][] seen = new boolean[grid.length][grid[0].length];


        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }




        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                queue.add(new Pair(i, 0));
                seen[i][0] = true;
            } 

            if (grid[i][grid[0].length-1] == 1) {
                queue.add(new Pair(i, grid[0].length-1));
                seen[i][grid[0].length-1] = true;
            }
        }


        for (int j = 1; j < grid[0].length-1; j++) {
            if (grid[0][j] == 1) {
                queue.add(new Pair(0, j));
                seen[0][j] = true;
            }

            if (grid[grid.length-1][j] == 1) {
                queue.add(new Pair(grid.length-1, j));
                seen[grid.length-1][j] = true;
            }
        }


        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};


        
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.remove();

            count--;
            System.out.println(pair.getKey() + " " + pair.getValue());
            System.out.println(count);

            for (int[] direction : directions) {
                int newX = pair.getKey() + direction[0];
                int newY = pair.getValue() + direction[1];


                if (newX > -1 && newX < grid.length && newY > -1 && newY < grid[0].length && grid[newX][newY] == 1 && !seen[newX][newY]) {
                    queue.add(new Pair<>(newX, newY));
                    seen[newX][newY] = true;
                }
            }
        }


        return count;
        
    }
}