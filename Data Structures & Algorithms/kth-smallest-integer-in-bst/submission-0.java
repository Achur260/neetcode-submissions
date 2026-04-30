/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> ts = new TreeSet<>();


        dfs(ts, root);
        int count = 0;
        int res = -1;

        for (Integer t : ts) {
            if (count == k - 1) {
                res = t;
                return res;
            }
            count++;
        }

        return -1;
    }

    public void dfs(TreeSet<Integer> ts, TreeNode curr) {
        if (curr == null)
            return;
        
        ts.add(curr.val);

        dfs(ts, curr.left);
        dfs(ts, curr.right);
    }
}
