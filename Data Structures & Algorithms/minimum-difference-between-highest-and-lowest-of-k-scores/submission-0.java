class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0;
        int end = k-1;

        int max = nums[end];
        int min = nums[start];

        

        if (max == min) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;

        while (end < nums.length) {
            minDiff = Math.min(minDiff, nums[end] - nums[start]);

            end++;
            start++;
        }


        return minDiff;
        
    }
}