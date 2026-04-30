class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        boolean[] dp = new boolean[s.length()];

        dp[0] = true;

        for (int i = 0; i < s.length()-1; i++) {
            if (dp[i] && s.charAt(i) == '0') {
                for (int j = i + minJump; j <= Math.min(i+maxJump, s.length()-1); j++) {
                    dp[j] = true;
                }
            }
        }

        return dp[s.length()-1] && s.charAt(s.length()-1) == '0';
        
    }
}