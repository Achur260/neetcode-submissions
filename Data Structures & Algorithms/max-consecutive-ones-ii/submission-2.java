class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {


        int start = 0;
        int end = 0;
        int zeros = 0;

        int maxLen = 0;
        int prevIndex = -1;

        while (end < nums.length) {
            if (nums[end] == 0) {
                if (zeros == 0) {
                    prevIndex = end;
                    end++;
                    maxLen = Math.max(maxLen, end - start);
                    zeros=1;
                    
                } else {

                    start = prevIndex+1;
                    start = Math.min(start, end);
                    prevIndex = end;

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
