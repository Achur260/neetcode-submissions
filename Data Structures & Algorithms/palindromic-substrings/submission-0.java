class Solution {

    int[][] memo;
    public int countSubstrings(String s) {
        memo = new int[s.length()][s.length()];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        int rs = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                rs += dp(s, i, j);
            }
        }

        return rs;
    }

    public int dp(String s, int i, int j) {
        if (i >= j) {
            return 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) != s.charAt(j)) 
            return memo[i][j] = 0;
        
        return memo[i][j] = dp(s, i+1, j-1);
    }

}
