class Solution {
    Map<Integer, Integer> counts;
    public List<List<Integer>> permuteUnique(int[] nums) {
        counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }


        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, new ArrayList<>(), ans);
        return ans;

    
        
    }


    public void helper(int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }


        for (int key : counts.keySet()) {
            if (counts.get(key) > 0) {
                counts.put(key, counts.get(key)-1);
                curr.add(key);
                helper(nums, curr, ans);
                counts.put(key, counts.get(key)+1);
                curr.removeLast();
            }
        }
    }
}