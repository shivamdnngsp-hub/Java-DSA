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

    TreeNode first = null;
    TreeNode second = null;
    TreeNode middle = null;
    TreeNode prev = null;
    void helper(TreeNode node){

        if(node == null){
            return;
        }

        helper(node.left);

         if(prev != null && prev.val> node.val){
        if(first == null){
            first = prev;
            middle = node;
        }else{
            second = node;
        }
       }

        prev = node;
        helper(node.right);
    }


    public void recoverTree(TreeNode root) {
        helper(root);

        if(second == null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }else{
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        return;
    }
}