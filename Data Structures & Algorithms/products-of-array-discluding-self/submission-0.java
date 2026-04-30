class Solution {
    public int[] productExceptSelf(int[] nums) {

        if (nums.length == 1) {
            return nums;
        }


        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int ans = nums[i];
            if (i > 0) {
                ans *= left[i-1];
            }
            left[i] = ans;
        }

        for (int i = nums.length-1; i > -1; i--) {
            int ans = nums[i];
            if (i < nums.length-1) {
                ans *= right[i+1];
            }
            right[i] = ans;
        }

        int[] ans = new int[nums.length];


        ans[0] = right[1];
        ans[nums.length-1] = left[nums.length-2];

        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = left[i-1]*right[i+1];
        }

        return ans;


        
    }
}  
