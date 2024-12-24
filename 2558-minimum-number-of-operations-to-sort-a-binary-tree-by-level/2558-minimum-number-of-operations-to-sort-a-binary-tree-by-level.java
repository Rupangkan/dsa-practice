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

    public int minimumOperations(TreeNode root) {
        int SHIFT = 20;
        int MASK = 0xFFFFF;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int swaps = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long[] nodes = new long[levelSize];

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                nodes[i] = ((long) node.val << SHIFT) + i;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            Arrays.sort(nodes);

            for (int i = 0; i < levelSize; i++) {
                int origPos = (int) (nodes[i] & MASK);
                if (origPos != i) {
                    long temp = nodes[i];
                    nodes[i--] = nodes[origPos];
                    nodes[origPos] = temp;
                    swaps++;
                }
            }
        }

        return swaps;
    }
}