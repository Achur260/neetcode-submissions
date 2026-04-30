class Solution {

    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dp(s, t, 0, 0);
    }

    public int dp(String s, String t, int i, int j) {
        
        
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }


        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int ans;
        if (s.charAt(i) == t.charAt(j)) {
            ans = dp(s, t, i + 1, j + 1) + dp (s, t, i + 1, j);
        } else {
            ans = dp(s, t, i + 1, j);
        }

        System.out.println(i + " " + j + " : " + ans);
        return memo[i][j] = ans;
    }
}
