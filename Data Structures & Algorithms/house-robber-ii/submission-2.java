class Solution {

    int[] memo;
    public int rob(int[] nums) {
        int max = Math.max(dp(nums, 0, nums.length-2), dp(nums, 1, nums.length-1));
        return Math.max(max, nums[0]);
    }

    public int dp(int[] nums, int i, int j) {

        int next = 0;
        int after = 0;

        for (int k = j; k >= i; k--) {
            int curr = Math.max(nums[k] + after, next);
            after = next;
            next = curr;
        }

        return next;
        
    }
}
