class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int[] seen = new int[nums.length+1];
        int unique = 0;
        int l = 0;

        int count1 = 0;

        for (int r = 0; r < nums.length; r++) {
            if (seen[nums[r]] == 0) {
                unique++;
            }

            seen[nums[r]]++;

            while (unique > k && l <= r) {
                seen[nums[l]]--;
                if (seen[nums[l]] == 0) {
                    unique--;
                }
                l++;
            }

            count1 += r - l + 1;
        }

        int[] seen2 = new int[nums.length+1];

        l = 0;
        
        int count2 = 0;
        unique=0;

        for (int r = 0; r < nums.length; r++) {
            if (seen2[nums[r]] == 0) {
                unique++;
            }

            seen2[nums[r]]++;

            while (unique > k - 1 && l <= r) {
                seen2[nums[l]]--;
                if (seen2[nums[l]] == 0) {
                    unique--;
                }
                l++;
            }

            count2 += r - l + 1;
        }


        return count1 - count2;


        
    }
}