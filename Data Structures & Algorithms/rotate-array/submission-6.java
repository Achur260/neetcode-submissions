class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        

        if (k == 0) {
            return;
        }


        int rem = nums.length % k;

        
        int count = nums.length;

        for (int i = 0; i < nums.length && count > 0; i++) {
             
            int j = (i + k) % nums.length;
            count--;

            while (j != i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                count--;

                j = (j+k)%nums.length;
            }
        }

        
    }
}