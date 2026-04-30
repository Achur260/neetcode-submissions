class Solution {

    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length())
            return false;

        memo = new int[s1.length()+1][s2.length()+1];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dp(s1, s2, s3, 0, 0);
        
    }

    public boolean dp(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        } 
        
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }   

        boolean first = false;
        boolean second = false;

        if (i < s1.length() && s3.charAt(i+j) == s1.charAt(i)) {
            first = dp(s1, s2, s3, i+1, j);
        } 
        
        if (j < s2.length() && s3.charAt(i+j) == s2.charAt(j)) {
            second = dp(s1, s2, s3, i, j+1);
        }

        boolean res = first || second;

        memo[i][j] = res ? 1 : 0;

        return res;

    }
}
