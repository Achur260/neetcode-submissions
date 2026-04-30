class Solution {
    public boolean canJump(int[] nums) {
        
        
        int maxRange = 0;
        int curr = 0;

        while (curr <= Math.min(maxRange, nums.length-1)) {

            System.out.println(maxRange);
            System.out.println(curr);
            System.out.println();

            int newRange = nums[curr];
            maxRange = Math.max(maxRange, newRange + curr);

            if (maxRange >= nums.length - 1) {
                return true;
            }

            curr++;


        }


        return false;
    }
}
