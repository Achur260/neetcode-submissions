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
                    System.out.println(maxLen + " " + currSum + " " + i + " " + j);
                    currSum -= nums[i++];
                    

                }

                j++;

                System.out.println();

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