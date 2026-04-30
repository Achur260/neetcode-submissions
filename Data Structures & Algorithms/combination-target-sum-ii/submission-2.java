class Solution {

    HashMap<Integer, Integer> hm;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        hm = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int num : candidates) {
            if (!hm.containsKey(num))
                nums.add(num);
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

    

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, target, nums, new ArrayList<Integer>(), ans);
        return ans;

        


    }


    public void backtrack(int i, int target, List<Integer> nums, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(curr));
            return;
        } else if (target < 0 || i == nums.size()) {
            return;
        }

        if (hm.get(nums.get(i)) > 0)
        {curr.add(nums.get(i));
        hm.put(nums.get(i), hm.get(nums.get(i)) - 1);
        backtrack(i, target-nums.get(i), nums, curr, ans);
        curr.removeLast();
        hm.put(nums.get(i), hm.get(nums.get(i)) + 1);}

        backtrack(i+1, target, nums, curr, ans);
    }
}
