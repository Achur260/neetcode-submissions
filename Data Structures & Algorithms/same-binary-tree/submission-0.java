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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        return helper(p, q);
        
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if (p != null && q == null) {
            return false;
        } else if (p == null && q != null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else {
            if (p.val == q.val) {
                return helper(p.left, q.left) && helper(p.right, q.right);
            } else {
                return false;
            }
        }

    }
}
