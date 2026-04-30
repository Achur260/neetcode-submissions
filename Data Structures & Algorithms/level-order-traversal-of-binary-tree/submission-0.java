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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
    
        List<Integer> ans = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int size = queue.size();

        while (size > 0) {
            TreeNode curr = queue.remove();
            ans.add(curr.val);
            size--;

            if (curr.left != null) {
                queue.add(curr.left);
            } 

            if (curr.right != null) {
                queue.add(curr.right);
            }

            if (size == 0) {
                res.add(new ArrayList<Integer>(ans));
                ans.clear();
                size = queue.size();
            }
        }


        return res;

    }
}
