class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0;
        

        int prev = 0;
    int k = 0;
        while (i < nums.length && prev < nums.length) {
            
            if (nums[i] == val) {


                
                int j = prev + 1;

                while (j < nums.length && nums[j] == val) {
                    j++;
                }

                if (j == nums.length) {
                    break;
                } 

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                prev = j;
                
            } 
            k++;
            i++;
            prev = Math.max(prev, i);
        }



        return k;
        
    }
}