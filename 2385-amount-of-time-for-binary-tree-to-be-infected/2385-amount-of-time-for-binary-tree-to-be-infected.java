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
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        TreeNode st = null;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.val == start) {
                    st = node;
                }
                if (node.left != null) {
                    mpp.put(node.left, node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    mpp.put(node.right, node);
                    q.offer(node.right);
                }
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        visited.add(st);
        q.offer(st);
        int min = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);

                }
                if (mpp.containsKey(node) && !visited.contains(mpp.get(node))) {
                    q.offer(mpp.get(node));
                    visited.add(mpp.get(node));

                }
            }
            min++;
        }

        return min-1;

    }
}