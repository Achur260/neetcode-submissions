class Solution {
    int[][] memo;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {

        sum = 0;

        for (int n : nums) {
            sum += n;
        }

        memo = new int[2*sum+1+target][nums.length];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dp(nums, target, 0);
        
    }

    public int dp(int[] nums, int target, int i) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        } else if (memo[target + sum][i] != -1) {
            return memo[target + sum][i];
        }

        return memo[target + sum][i] = dp(nums, target-nums[i], i + 1) + dp(nums, target+nums[i], i + 1);
    }
}
