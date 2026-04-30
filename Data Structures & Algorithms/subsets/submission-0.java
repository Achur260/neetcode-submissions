class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        helper(nums, 0, curr, ans);

        return ans;
    
    }

    public void helper(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        helper(nums, i+1, curr, ans);


        curr.add(nums[i]);
        helper(nums, i+1, curr, ans);
        curr.removeLast();


    }
}
