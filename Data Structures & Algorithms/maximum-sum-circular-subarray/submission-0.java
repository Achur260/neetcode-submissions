class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int min = nums[0];
        int max = nums[0];
        int currMax = 0;
        int currMin = 0;
        int total = 0;

        for (int num: nums) {
            currMax = Math.max(num, currMax + num);
            currMin = Math.min(num, currMin + num);

            total += num;

            max = Math.max(max, currMax);
            min = Math.min(min, currMin);

        }

        return max > 0 ? Math.max(max, total-min) : max;
    }
}