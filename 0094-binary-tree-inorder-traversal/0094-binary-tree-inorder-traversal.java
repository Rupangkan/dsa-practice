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

    // Optimal Morris Inorder Traversal - 
    // O(h)
    // O(1)
    public List<Integer> optimal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    
    // Space O(n)
    public void search(List<Integer> ans, TreeNode root) {
        if(root == null) return;
        search(ans, root.left);
        ans.add(root.val);
        search(ans, root.right);
    }

    public List<Integer> better(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        search(ans, root);
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return better(root);
    }
}