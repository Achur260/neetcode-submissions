class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end)  {
            if (nums[start] == target) {
                return start;
            } 

            if (nums[end] == target) {
                return end;
            }

            int mid = (start + end)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[start]) {
                if (target > nums[start] && target < nums[mid]) {
                    start++;
                    end = mid - 1;
                } else {
                    start= mid + 1;
                    end--;
                }

            } else {
                if (target > nums[start] || target < nums[mid]) {
                    start++;
                    end = mid-1;
                } else {
                    start = mid + 1;
                    end--;
                }

            }
        }

        return -1;
        
    }
}
