class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] m: memo) {
            Arrays.fill(m, -1);
        }
        return dp(word1, word2, 0, 0);
        
    }

    public int dp(String w1, String w2, int i, int j) {
        if(j == w2.length()){
            return w1.length() - i;
        }
        
        if (i == w1.length()) {
            return w2.length()-j;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (w1.charAt(i) == w2.charAt(j)) {
            
            memo[i][j] = dp(w1, w2, i+1, j+1);

            System.out.println(i + " " + j + " " + memo[i][j]);
            return memo[i][j];
        }

        int insert = 1 + dp(w1,w2,i,j+1);
        int delete = 1 + dp(w1,w2,i+1,j);
        int replace = 1 + dp(w1,w2,i+1,j+1);

        memo[i][j] = Math.min(insert, Math.min(delete, replace));
        System.out.println(i + " " + j + " " + memo[i][j]);
        return memo[i][j];
    }
}
