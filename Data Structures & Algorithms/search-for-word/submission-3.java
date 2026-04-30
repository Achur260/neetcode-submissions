class Solution {

    boolean[][] seen;
    public boolean exist(char[][] board, String word) {
        seen = new boolean[board.length][board[0].length];
        

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j , 0)) {
                        System.out.println(i + " " + j);
                        return true;
                    }
                    seen = new boolean[board.length][board[0].length];
                }
            }
        }
        return false;
        
    }

    public boolean helper(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        
        if (!isValid(i, j, board.length, board[0].length) || board[i][j] != word.charAt(k) || seen[i][j]) {
            return false;
        }

        seen[i][j] = true;

        
        boolean ans = helper(board, word, i+1, j, k+1) || helper(board, word, i, j+1, k+1) || helper(board, word, i-1, j, k+1) || helper(board, word, i, j-1, k+1);

        seen[i][j] = false;

        return ans;




    }

    public boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
