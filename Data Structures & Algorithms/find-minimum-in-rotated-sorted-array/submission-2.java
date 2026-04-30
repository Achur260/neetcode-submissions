class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;


        while (start < end) {
            if (nums[start] > nums[end]) {
                int mid = start + end;
                mid /=2;


                if (nums[mid] > nums[start]) {
                    start = mid + 1;
                } else {
                    start++;
                    end = mid;
                }

            } else {
                return nums[start];
            }
        }


        return nums[start];
        
    }
}
