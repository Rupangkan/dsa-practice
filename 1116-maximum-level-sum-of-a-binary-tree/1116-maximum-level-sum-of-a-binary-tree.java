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
    void dfs(TreeNode n, int d, List<Integer> s) {
        if (n == null) return;
        if (s.size() == d) s.add(n.val);
        else s.set(d, s.get(d) + n.val);
        dfs(n.left, d + 1, s);
        dfs(n.right, d + 1, s);
    }

    public int maxLevelSum(TreeNode root) {
        List<Integer> s = new ArrayList<>();
        dfs(root, 0, s);
        int mx = Integer.MIN_VALUE, ans = 1;
        for (int i = 0; i < s.size(); i++)
            if (s.get(i) > mx) {
                mx = s.get(i);
                ans = i + 1;
            }
        return ans;
    }
}
