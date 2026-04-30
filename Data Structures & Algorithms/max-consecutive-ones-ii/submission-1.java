class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {


        int start = 0;
        int end = 0;
        int zeros = 0;

        int maxLen = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                if (zeros == 0) {
                    end++;
                    maxLen = Math.max(maxLen, end - start);
                    zeros=1;
                } else {

                    while (start < end && nums[start] == 1) {
                        start++;
                    }

                    start++;

                    end++;
                    maxLen = Math.max(maxLen, end-start);

                }
            } else {
                end++;
                maxLen = Math.max(maxLen, end - start);
            }

        }


        return maxLen;
        
    }
}
