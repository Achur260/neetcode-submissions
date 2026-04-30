class Solution {

    int[][] memo;
    int s;
    public boolean canPartition(int[] nums) {

        s = 0;
        for (int n : nums) {
            s += n;
        }
        
        memo = new int[nums.length + 1][2*s+1];

        for (int[] m : memo) {
            Arrays.fill(m, 0);
        }

        return dp(nums, 0, 0);

    }

    public boolean dp(int[] nums, int i, int sum) {
        if (i == nums.length) {
            return sum == 0;
        }

        if (memo[i][sum+s] != 0) {
            return memo[i][sum+s] == 2;
        } 


        boolean ans = dp(nums, i + 1, sum + nums[i]) || dp(nums, i + 1, sum - nums[i]);
        System.out.println(ans);
        memo[i][sum+s] = ans ? 2 : 1;

        

        return ans;
    
    }
}
