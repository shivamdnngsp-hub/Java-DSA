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
     void helper(TreeNode node){
        if(node == null){
            return;
        }

         helper(node.left);
         helper(node.right);
         if(node.left == null){
            return;
         }
         
         TreeNode prev = node.left;
         while(prev.right != null){
            prev = prev.right;
         }

        prev.right = node.right;
        node.right = node.left;
        node.left = null;
     }
    public void flatten(TreeNode root) {
        helper(root);
    }
}