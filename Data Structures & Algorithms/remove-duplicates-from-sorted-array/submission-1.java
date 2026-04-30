class Solution {
    public int removeDuplicates(int[] nums) {


        int val = nums[0];
        int c = 1;
        int i = 1;
        int prev = 1;
        while (i < nums.length && prev < nums.length) {

            

            int j = i;
            while (j < nums.length && nums[j] == val) {
                j++;
            }

            if (j == nums.length) {
                break;
            }

            int temp = nums[j];
            nums[j] = nums[prev];
            nums[prev] = temp;
            prev++;
            i = j+1;
            val = temp;
            c++;

        }

        return c;
        
    }
}