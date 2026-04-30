class Solution {
    public void solve(char[][] board) {

        Queue<Integer[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        int m = board.length;
        int n = board[0].length;
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.add(new Integer[] {i , 0});
                seen[i][0] = true;
            }
            if (board[i][n-1] == 'O') {
                queue.add(new Integer[] {i , n-1});
                seen[i][n-1] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !seen[0][j]) {
                queue.add(new Integer[] {0 , j});
                seen[0][j] = true;

            }

            if (board[m-1][j] == 'O' && !seen[m-1][j]) {
                queue.add(new Integer[] {m-1 , j});
                seen[m-1][j] = true;

            }
        }


        while (!queue.isEmpty()) {
            Integer[] curr = queue.remove();

            for (int[] dir : dirs) {
                int newX = dir[0] + curr[0];
                int newY = dir[1] + curr[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !seen[newX][newY] && board[newX][newY] == 'O') {
                    queue.add(new Integer[]{newX, newY});
                    seen[newX][newY] = true;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!seen[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}
