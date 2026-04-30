class Solution {

    int[] memo;
    public String stoneGameIII(int[] stoneValue) {
        
        memo = new int[stoneValue.length];
        Arrays.fill(memo, -1);
        int res = dp(stoneValue, 0);
        

        if (res == 0) {
            return "Tie";
        } else if (res > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public int dp(int[] stoneValue, int i) {
        if (i == stoneValue.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int size = 1; size <= 3; size++) {
            int currIndex = i + size -1;
            if (currIndex >= stoneValue.length) {
                break;
            }

            sum += stoneValue[currIndex];
            ans = Math.max(ans, sum - dp(stoneValue, currIndex+1));
        }


        return memo[i] = ans;
    }
}