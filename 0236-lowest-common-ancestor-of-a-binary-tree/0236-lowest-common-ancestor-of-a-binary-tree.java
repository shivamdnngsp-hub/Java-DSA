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
        if(node == p || node == q){
            return node;
        }
        
       TreeNode n1=  helper(node.left,p,q);
       TreeNode n2 =  helper(node.right,p,q);
       if(n1 != null && n2 != null){
        return node;
       }
       
       else if(n1 != null){
        return n1;
       }else if(n2 != null){
        return n2;
       }
       return null;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     return helper(root,p,q);
    }
}