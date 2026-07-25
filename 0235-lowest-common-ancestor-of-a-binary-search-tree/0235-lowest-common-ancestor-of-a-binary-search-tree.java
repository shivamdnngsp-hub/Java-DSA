/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode helper(TreeNode node,TreeNode p,TreeNode q){
        if(node == null){
            return null;
        }

        TreeNode l = helper(node.left,p,q);
        TreeNode r = helper(node.right,p,q);
    
        if(node.val == p.val || node.val == q.val){
            return node;
        }
         
         if(l != null && r != null){
            return node;
         }

         if(l != null){
            return l;
         }

         if(r != null){
            return r;
         }

return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }
}