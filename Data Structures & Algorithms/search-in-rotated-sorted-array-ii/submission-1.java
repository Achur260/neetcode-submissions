class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left-right)/2 + right;
            if (nums[left] == target || nums[right] == target) {
                return true;
            }
            System.out.println(mid);
            System.out.println(left);
            System.out.println(right);
            System.out.println();
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } 

            else if (nums[mid] < nums[left]) {
                if (target < nums[mid] || target > nums[left]) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } 

            else {
                left++;
            }


        }


        return false;
        
    }
}