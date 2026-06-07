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

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> child = new HashSet<>();

        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];

            TreeNode par = mp.computeIfAbsent(p, TreeNode::new);
            TreeNode ch = mp.computeIfAbsent(c, TreeNode::new);

            if (d[2] == 1) {
                par.left = ch;
            } else {
                par.right = ch;
            }

            child.add(c);
        }

        for (int x : mp.keySet()) {
            if (!child.contains(x)) {
                return mp.get(x);
            }
        }

        return null;
    }
}