class Solution {
    public int[] sortArray(int[] nums) {


        sort(nums, 0, nums.length-1);
        return nums;
        
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start+end)/2;

        sort(nums, start, mid);
        sort(nums, mid+1, end);

        int[] copy = Arrays.copyOfRange(nums, start, end+1);

        int i = 0;
        int j = mid+1-start;
        int k = start;


        while (i <= mid-start && j < copy.length) {
            if (copy[i] < copy[j]) {
                nums[k] = copy[i];
                i++;
                k++;
            } else {
                nums[k] = copy[j];
                j++;
                k++;
            }
        }


        while (i <= mid-start) {
            nums[k++] = copy[i++];
        }

        while (j <= end-start) {
            nums[k++] = copy[j++];
        }


    }
}