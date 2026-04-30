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
    HashMap<TreeNode, Integer> hm;
    public int rob(TreeNode root) {

        hm = new HashMap<>();

        return helper(root);
        
        
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (hm.containsKey(root)) {
            return hm.get(root);
        }

        int noRob = helper(root.left) + helper(root.right);

        int yesRob = root.val;

        if (root.left != null) {
            yesRob += helper(root.left.left) + helper(root.left.right);
        }

        if (root.right != null) {
            yesRob += helper(root.right.left) + helper(root.right.right);
        }

        int ans = Math.max(noRob, yesRob);

        hm.put(root, ans);
        return ans;
    }
}