class Solution {

    int[][] memo;
    public String longestPalindrome(String s) {
        memo = new int[s.length()][s.length()];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        int maxLen = 0;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                dp(s, i, j);
                if (memo[i][j] == 1) {
                    if (maxLen < j-i+1) {
                        maxLen = j - i + 1;
                        System.out.println(maxLen);
                        ans = s.substring(i, j+1);
                    }

                }
            }
        }


        return ans;
    }

    private int dp(String s, int i, int j) {
        if (i >= j) {
            return memo[i][j] = 1;
        } 

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s.charAt(i) != s.charAt(j))
            return memo[i][j] = 0;
        
        return memo[i][j] = dp(s, i+1, j-1);


    }
}
