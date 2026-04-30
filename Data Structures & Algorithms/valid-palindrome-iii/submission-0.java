class Solution {
    int[][][] memo;
    public boolean isValidPalindrome(String s, int k) {
        memo = new int[k+1][s.length()][s.length()];
        for (int[][] me : memo) {
            for (int[] m : me) {
                Arrays.fill(m, -1);
            }
        }
        return helper(s, k, 0, s.length()-1);
        
    }

    public boolean helper(String s, int k, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (memo[k][start][end] != -1) {
            return memo[k][start][end] == 1;
        }

        if (s.charAt(start) == s.charAt(end)) {
            boolean ans = helper(s, k, start+1, end-1);
            memo[k][start][end] = ans ? 1 : 0;
            return ans;
        } else {
            if (k == 0) {
                return false;
            }

            boolean ans = helper(s, k-1, start+1, end) || helper(s, k-1, start, end-1);
            memo[k][start][end] = ans ? 1 : 0;
            return ans;
        }
    }
}
