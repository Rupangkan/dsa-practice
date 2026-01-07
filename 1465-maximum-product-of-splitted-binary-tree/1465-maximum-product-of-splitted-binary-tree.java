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
    long MOD = 1_000_000_007L, ans = 0;

    long dfs(TreeNode n) {
        if (n == null) return 0;
        return n.val += dfs(n.left) + dfs(n.right);
    }

    public int maxProduct(TreeNode root) {
        long total = dfs(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            long cur = (total - n.val) * n.val;
            ans = Math.max(ans, cur);
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return (int)(ans % MOD);
    }
}
