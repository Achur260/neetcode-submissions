class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int s = 0;

        for (int n : nums) {
            s += n;
        }

        if (s % k != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        int target = s / k;
        return backtrack(nums, new int[k], nums.length - 1, target);
    }

    private boolean backtrack(int[] nums, int[] sums, int index, int target) {
        if (index < 0) {
            return true;
        }

        int n = nums[index];
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + n <= target) {
                sums[i] += n;
                if (backtrack(nums, sums, index - 1, target)) return true;
                sums[i] -= n;
            }
            if (sums[i] == 0) break;
        }
        return false;
    }
}