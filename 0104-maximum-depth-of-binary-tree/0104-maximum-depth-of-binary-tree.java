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
    public void helper(TreeNode node, List<Integer> ans, int d) {
        if (node == null) {
            ans.set(0,Math.max(ans.get(0),d));
            return;
        }

        d++;
        helper(node.left, ans, d);
        helper(node.right, ans, d);
        d--;
        return;
    }

    public int maxDepth(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        helper(root,ans,0);
        return ans.get(0);

    }
}