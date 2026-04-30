class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int n: nums) {
            hs.add(n);
        }
        helper(ans, hs, new ArrayList<Integer>());

        return ans;
        
    }

    public void helper(List<List<Integer>> ans, HashSet<Integer> hs, List<Integer> curr) {
        if (hs.size() == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : hs) {
            HashSet<Integer> newHs = new HashSet<Integer>(hs);
            newHs.remove(num);
            curr.add(num);
            helper(ans, newHs, curr);
            curr.removeLast();
        }





    }
}
