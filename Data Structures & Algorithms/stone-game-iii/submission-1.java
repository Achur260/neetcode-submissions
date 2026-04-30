class Solution {

    public String stoneGameIII(int[] stoneValue) {
        
        int[] dp = new int[stoneValue.length + 1];

        for (int i = stoneValue.length -1; i >= 0; i--) {
            int sum = 0;
            int ans = Integer.MIN_VALUE;
            for (int size = 1; size <= 3; size++) {
                int currIndex = i + size -1;
                if (currIndex >= stoneValue.length) {
                    break;
                }

                sum += stoneValue[currIndex];
                ans = Math.max(ans, sum - dp[currIndex+1]);
            }  

            dp[i] = ans; 

        }
        int res = dp[0];
        

        if (res == 0) {
            return "Tie";
        } else if (res > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

}