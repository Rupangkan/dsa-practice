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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).n;
    }

    private Pair dfs(TreeNode r) {
        if (r == null) return new Pair(null, 0);
        Pair l = dfs(r.left), rt = dfs(r.right);
        if (l.d > rt.d) return new Pair(l.n, l.d + 1);
        if (l.d < rt.d) return new Pair(rt.n, rt.d + 1);
        return new Pair(r, l.d + 1);
    }
}

class Pair {
    TreeNode n;
    int d;
    Pair(TreeNode n, int d) {
        this.n = n;
        this.d = d;
    }
}
