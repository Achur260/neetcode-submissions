class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    public int partition(int[] nums, int start, int end) {

        if (start == end - 1) {
            if (nums[start] > nums[end]) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                return end;
            } else {
                return start;
            }
        }
        int pivot = nums[start];

        int i = start+1;
        int j = end;

        while (i < j) {
            while (i < end && nums[i] <= pivot) {
                i++;
            }

            while (j > start && nums[j] >= pivot) {
                j--;
            }


            if (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;}
            
        }

        nums[start] = nums[j];
        nums[j] = pivot;

        return j;
    }


    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int x = partition(nums, start, end);

        sort(nums, start, x-1);
        sort(nums, x+1, end);



    }
}