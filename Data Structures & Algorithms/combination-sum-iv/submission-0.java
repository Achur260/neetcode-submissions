class Solution {


    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo= new int[target+1];
        Arrays.fill(memo, -1);
        return helper(nums, target);

        
    }


    public int helper(int[] nums, int target) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (memo[target] != -1) {
            return memo[target];
        }

        int ans = 0;

        for (int num : nums) {
            ans += helper(nums, target-num);
        }

        return memo[target]=ans;
    }
}