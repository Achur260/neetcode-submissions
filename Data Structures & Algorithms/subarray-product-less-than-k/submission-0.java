class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        

        int start = 1;
        int count = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {

            start *= nums[right];

            
            while (start >= k && left <= right) {
                start /= nums[left++];
            }
            count += right - left + 1;
            right++;
            
        }

        return count;
    }
}