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
    boolean helper(TreeNode node,long min,long max){
    if(node == null) return true;

    if(node.val<=min || node.val>=max){
        return false;
    }
   
    if(helper(node.left,min,node.val) == false|| helper(node.right,node.val,max) == false){
        return false;
    }

       return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}