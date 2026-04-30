class Solution {
    public int rob(int[] nums) {
        
        int after = 0;
        int next = nums[nums.length-1];

        for (int j = nums.length - 2; j >= 0; j--) {
            int curr = Math.max(next, nums[j] + after);
            after = next;
            next = curr;
        }

        return next;
    }
}
