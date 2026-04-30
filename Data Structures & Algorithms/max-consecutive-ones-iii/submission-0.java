class Solution {
    public int longestOnes(int[] nums, int k) {

        int rem = k;

        int maxLen = 0;
        int start = 0;
        int end = 0;
        

        while (end < nums.length) {

            if (nums[end] == 0) {
                if (rem != 0) {
                    rem--;
                    end++;
                    maxLen = Math.max(maxLen, end-start);
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
                maxLen = Math.max(maxLen, end-start);
            }



        }


        return maxLen;
        
    }
}