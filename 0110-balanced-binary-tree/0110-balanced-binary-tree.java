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
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int l = height(node.left);
        if (l < 0) return -1;

        int r = height(node.right);
        if (r < 0) return -1;

        if (Math.abs(l - r) > 1) return -1;

        return Math.max(l, r) + 1;
    }
}
