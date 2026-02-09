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

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> a = new ArrayList<>();
        dfs(root, a);
        return build(a, 0, a.size() - 1);
    }

    private void dfs(TreeNode r, ArrayList<Integer> a) {
        if (r == null) return;
        dfs(r.left, a);
        a.add(r.val);
        dfs(r.right, a);
    }

    private TreeNode build(ArrayList<Integer> a, int l, int r) {
        if (l > r) return null;
        int m = (l + r) >>> 1;
        TreeNode x = new TreeNode(a.get(m));
        x.left = build(a, l, m - 1);
        x.right = build(a, m + 1, r);
        return x;
    }
}
