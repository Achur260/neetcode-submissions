class Solution {
    HashMap<Integer, Integer> hm;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(hm.keySet());

        helper(keys, 0, new ArrayList<Integer>(), ans);


        return ans;
    }

    public void helper(List<Integer> keys, int i, List<Integer> curr, List<List<Integer>> ans) {
        if (i == keys.size()) {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }

        for (int j = 0; j < hm.get(keys.get(i)); j++) {
            curr.add(keys.get(i));
            helper(keys, i+1, curr, ans);
        }

        while (!curr.isEmpty() && curr.getLast() == keys.get(i)) {
            curr.removeLast();
        }

        helper(keys, i+1, curr, ans);
    }
}
