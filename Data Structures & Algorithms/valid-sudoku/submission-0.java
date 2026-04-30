class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashSet<Character> hs = new HashSet<>();

            for (char num : board[i]) {
                if (hs.contains(num)) 
                    return false;
                if (num != '.')
                    hs.add(num);
            }
        }

        for (int j = 0; j < 9; j++) {
            HashSet<Character> hs = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                if (hs.contains(board[i][j]))
                    return false;
                if (board[i][j] != '.')
                    hs.add(board[i][j]);
            }
        }

        List<HashSet<Character>> boxes = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int r = i/3;
                int c = j/3;
                int box = 3*r + c;

                if (boxes.get(box).contains(board[i][j]))
                    return false;
                if (board[i][j] != '.') 
                    boxes.get(box).add(board[i][j]);
            }
        }

        return true;


        
    }
}
