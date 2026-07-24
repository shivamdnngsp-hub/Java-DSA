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
     TreeNode helper(TreeNode node,int val){
        if(node == null) return null;
        if(node.val == val){
            return node;
        }
        return node.val>val ? helper(node.left,val) : helper(node.right,val);
     }
    public TreeNode searchBST(TreeNode root, int val) {
        return helper(root,val);
    }
}