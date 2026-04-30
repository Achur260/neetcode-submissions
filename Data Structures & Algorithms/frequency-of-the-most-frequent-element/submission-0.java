class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);


        int currSum = 0;

        int max = 0;
        int l = 0;


        for (int r = 0; r < nums.length; r++) {

            currSum += nums[r];

            while ((r-l+1)*nums[r] > currSum + k) {
                currSum -= nums[l++];
            }

            max = Math.max(max, r-l+1);
        }

        return max;
        
    }
}