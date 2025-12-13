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
    public void recur(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        ans.add(root.val);
        recur(root.left, ans);
        recur(root.right, ans);
    }

    public void iter(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> st = new Stack<>();
        if (root == null) return;
        st.add(root);

        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            ans.add(curr.val);
            if(curr != null && curr.right != null) {
                st.add(curr.right);
            }
            if(curr != null && curr.left != null) {
                st.add(curr.left);
            }
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        iter(root, ans);
        return ans;
    }
}