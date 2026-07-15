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
    boolean balanced = true;
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = helper(node.left);
        int r = helper(node.right);

       int diff  = Math.abs(l- r);
       if(diff >1){
         balanced = false;
       }

      return  1 + Math.max(l,r);
    }


    public boolean isBalanced(TreeNode root) {
       helper(root);
       return balanced;
    }
}