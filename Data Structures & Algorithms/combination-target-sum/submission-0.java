class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();

        helper(nums, list, new ArrayList<Integer>(), target, 0);

        return list;

        
    }


    public void helper(int[] nums, List<List<Integer>> list, List<Integer> curr, int rem, int i) {
        if (rem < 0) {
            return;
        }
        
        if (rem == 0) {
            list.add(new ArrayList<Integer>(curr));
        }

        for (int j = i; j < nums.length; j++) {

            int num = nums[j];
            int newSum = rem - num;
            curr.add(num);
            helper(nums, list, curr, newSum, j);
            curr.remove((Integer) num);

        }
    }
}
