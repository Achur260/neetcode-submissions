class Solution {

    int[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];

        return dp(s,p,0,0);
    }


    public boolean dp(String s, String p, int i, int j) {

        if (i >= s.length()) {
            boolean ans = j == p.length();

            if (j < p.length() - 1 && p.charAt(j+1) == '*')
                ans = ans ||  dp(s,p,i,j+2);

            return ans;
        }

        if (j == p.length()) {
            return false;
        }

        if (memo[i][j] != 0) {
            return memo[i][j] == 2;
        }

        if (j < p.length()-1 && p.charAt(j+1) == '*') {
            boolean skip = dp(s,p,i,j+2);

            if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                skip = skip || dp(s,p,i+1,j);
            }
            memo[i][j] = skip ? 2 : 1;

            System.out.println(s.substring(i) + " " + p.substring(j) + " " + skip);
            return skip;


        } else {
            boolean ans = false;
            if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
                ans = dp(s,p,i+1,j+1);
            memo[i][j] = ans ? 2 : 1;
            System.out.println(s.substring(i) + " " + p.substring(j) + " " + ans);
            return ans;
        }
    }
}
