class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;
        int maxLen = Integer.MAX_VALUE;
        int currSum = 0;

        while (j < nums.length) {
            currSum += nums[j];
            if (currSum >= target) {
                

                while (i <= j && currSum >= target) {
                    maxLen = Math.min(maxLen, j + 1 - i);
                    currSum -= nums[i++];
                    

                }

                j++;

                if (i > j) {
                    j = i;
                    currSum = 0;
                }
                
            } else {
                j++;
            }
        }

        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
        
    }
}