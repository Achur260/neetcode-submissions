class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        helper(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    public void helper (List<List<Integer>> res, List<Integer> curr, int n, int k, int i) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }

        if (i > n) {
            return;
        }

        curr.add(i);
        helper(res, curr, n, k-1, i+1);
        curr.removeLast();

        helper(res, curr, n, k, i+1);
    }
}