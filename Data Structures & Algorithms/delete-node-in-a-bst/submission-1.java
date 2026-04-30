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
    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode prev = root;
        TreeNode curr = root;

        while (curr != null && curr.val != key) {
            if(key > curr.val) {
                prev = curr;
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            } 
        }

        if (curr == null) {
            return root;
        }

        if (curr.right == null && curr.left == null) {
            if (curr == root) {
                root = null;
            }
            System.out.println(curr.val);
            if (prev.left == curr) {
                prev.left = null;
            } else {
                prev.right = null;
            }
            return root;
        }

        if (curr.right == null) {
            if (root == curr) {
                root = root.left;
            } else {
                if (prev.val > curr.val) {
                    prev.right = curr.left;
                } else {
                    prev.left = curr.left;
                }
            }
        } else {
            TreeNode nPrev = curr.right;
            TreeNode nCurr = curr.right;

            while (nCurr.left != null) {
                nPrev = nCurr;
                nCurr = nCurr.left;
            }

            if (nCurr == curr.right) {
                if (curr == root) {
                    nCurr.left = curr.left;
                    root = nCurr;
                } else {
                    nCurr.left = curr.left;

                    if (prev.val > curr.val) {
                        prev.left = nCurr;
                    } else {
                        prev.right = nCurr;
                    }
                }

            } else {
                TreeNode nRight = nCurr.right;
                nPrev.left = nRight;
                nCurr.right = curr.right;
                nCurr.left = curr.left;

                if (root == curr) {
                    root = nCurr;
                } else {
                    if (prev.val > curr.val) {
                        prev.left = nCurr;
                    } else {
                        prev.right = nCurr;
                    }
                }

            }
        }


        return root;
        
    }
}