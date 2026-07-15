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
     int diameter = 0;
    int  helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = helper(node.left);
        int r = helper(node.right);
        diameter  = Math.max(l+r,diameter);

        return 1 + Math.max(l,r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
}