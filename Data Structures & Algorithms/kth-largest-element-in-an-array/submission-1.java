class Solution {
    public int findKthLargest(int[] nums, int k) {

        return findK(nums, k, 0, nums.length-1);
        
    }

    public int findK(int[] nums, int k, int start, int end) {
        int index = partition(nums, start, end);
        int desiredIndex = end - k + 1;
        if (index == desiredIndex) {
            return nums[index];
        } else if (index < desiredIndex) {
            return findK(nums, k, index + 1, end);
        } else {
            return findK(nums, index - desiredIndex, start, index - 1);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start+1;
        int j = end; 

        while (i <= j) {
            if (nums[i] > pivot && nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }


            if (nums[i] <= pivot) {
                i++;
            } 
            
            if (nums[j] >= pivot) {
                j--;
            }

            
        }

        nums[start] = nums[j];
        nums[j] = pivot;


        return j;
    }
}
