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
    int idx = 0;
    HashMap<Integer, Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        

        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }


        return dfs(preorder, 0, preorder.length-1);
        
    }


    public TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }

        int val = preorder[idx++];
        int index = indexes.get(val);

        TreeNode curr = new TreeNode(val);


        curr.left = dfs(preorder, l, index-1);
        curr.right = dfs(preorder, index+1, r);

        return curr;

    }
}
