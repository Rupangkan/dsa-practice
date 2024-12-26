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

    void dfs(TreeNode root, int d, List<Integer> ans) {
        if(root == null) return;
        if(d == ans.size()) {
            ans.add(root.val);
        } else {
            ans.set(d, Math.max(ans.get(d), root.val));
        }

        dfs(root.left, d + 1, ans);
        dfs(root.right, d + 1, ans);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
}