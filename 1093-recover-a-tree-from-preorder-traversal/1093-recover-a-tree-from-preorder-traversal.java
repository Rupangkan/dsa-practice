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
    public TreeNode recoverFromPreorder(String traversal) {
        List<TreeNode> l = new ArrayList<>();
        int ind = 0, n = traversal.length();

        while(ind < n) {
            int d = 0, v = 0;
            while(ind < n && traversal.charAt(ind) == '-') {
                d++;
                ind++;
            }
            while(ind < n && Character.isDigit(traversal.charAt(ind))) {
                v = v * 10 + (traversal.charAt(ind) - '0');
                ind++;
            }

            TreeNode node = new TreeNode(v);

            if (d < l.size()) {
                l.set(d, node);
            } else {
                l.add(node);
            }

            if(d > 0) {
                TreeNode p = l.get(d - 1);
                if(p.left == null) p.left = node;
                else p.right = node;

            }
        }

        return l.get(0);
    }
}