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

        int[] copy = Arrays.copyOf(nums, nums.length);

        int i = start;
        int j = mid+1;
        int k = start;


        while (i <= mid && j <= end) {
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


        while (i <= mid) {
            nums[k++] = copy[i++];
        }

        while (j <= end) {
            nums[k++] = copy[j++];
        }


    }
}