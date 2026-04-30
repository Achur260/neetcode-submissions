class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[nums.length-1];
        int min = nums[nums.length-1];
        int tMax = max;
        System.out.println(min + " " + max + " " + tMax);
        for (int i = nums.length - 2; i > -1; i--) {

            
            
            int currMax = Math.max(nums[i]*max, nums[i]*min);

            currMax = Math.max(currMax, nums[i]);
            
            int currMin = Math.min(nums[i]*max, nums[i]*min);
            currMin = Math.min(currMin, nums[i]);


            tMax = Math.max(tMax, currMax);
            max = currMax;
            min = currMin;

            System.out.println(min + " " + max + " " + tMax);

            
            
        }


        return tMax;
    }
}
