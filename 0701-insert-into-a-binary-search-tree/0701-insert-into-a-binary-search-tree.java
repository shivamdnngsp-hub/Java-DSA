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

    public TreeNode insertIntoBST(TreeNode root, int val) {
      TreeNode node = root;
      if(root == null){
        return new TreeNode(val);
      }
      while(node != null){
        
         if(node.left == null && node.val>val){
            node.left = new TreeNode(val);
            break;
         }
         if(node.right == null && node.val<val){
            node.right = new TreeNode(val);
            break;
         }

        if(node.val>val){
            node = node.left;
        }else{
            node = node.right;
        }

      }

       return root;
    }
}