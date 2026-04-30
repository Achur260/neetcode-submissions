class Solution {


    int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    boolean[][] seen;
    public List<String> findWords(char[][] board, String[] words) {
        seen = new boolean[board.length][board[0].length];
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode temp = root;
            System.out.println(temp.children.keySet());

            for (char ch : word.toCharArray()) {
                
                temp.children.putIfAbsent(ch, new TrieNode());
                temp = temp.children.get(ch);

            }
            temp.isWord = true;
        }

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(root, hs, board, i, j , "");
                seen = new boolean[board.length][board[0].length];
            }

        }

    
        return new ArrayList<String>(hs);


        
    }

    public void dfs(TrieNode curr, HashSet<String> words, char[][] board, int i, int j, String currS) {
        

        if (curr.isWord == true) {
            words.add(currS);
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || !curr.children.containsKey(board[i][j]) || seen[i][j] ) {
            return;
        }

        String newS = currS + board[i][j];
        TrieNode newT = curr.children.get(board[i][j]);

        seen[i][j] = true;

        for (int[] dir : dirs) {
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
            dfs(newT, words, board, newI, newJ, newS);
        }

        seen[i][j] = false;


        

        

    }
}

class TrieNode {

    boolean isWord;
    HashMap<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}
