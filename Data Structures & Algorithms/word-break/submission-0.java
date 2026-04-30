class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()]; 
        Arrays.fill(dp, -1);
        return dp(s, wordDict, 0);
        
    }

    public boolean dp(String s, List<String> wordDict, int i) {
        if (i == s.length()) {
            return true;
        }

        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        for (String word : wordDict) {

            if (i + word.length() > s.length()) {
                continue;
            }
            String curr = s.substring(i, i + word.length());

            if (curr.equals(word) && dp(s, wordDict, i+word.length())) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}
