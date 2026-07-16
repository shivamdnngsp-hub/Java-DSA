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
    boolean helper(TreeNode node1 , TreeNode node2){
        if(node1 == null){
            if(node2 != null){
                return false;
            }
        }

         if(node2 == null){
            if(node1 != null){
                return false;
            }
        }
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1.val != node2.val){
            return false;
        }
        

        if(!helper(node1.left,node2.left)){
            return false;
        }
       
       if(!helper(node1.right,node2.right)){
            return false;
        }
      
      return true;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
    return helper(p,q);
    }
}