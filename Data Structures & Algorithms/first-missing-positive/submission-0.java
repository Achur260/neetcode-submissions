class Solution {
    public int firstMissingPositive(int[] nums) {
        

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);

            if (a > 0 && a <= nums.length) {
                if (nums[a-1] > 0) {
                    nums[a-1]*=-1;
                } else {
                    nums[a-1] = -1 * (nums.length+1);
                }
            }
        }


        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] >= 0) {
                return i;
            }
        }

        return nums.length+1;


    }
}