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
    int ans =  Integer.MIN_VALUE;
    int helper(TreeNode node){
        if(node == null){
            return 0;
        }

    
     int ls = Math.max(0,helper(node.left));
     int rs = Math.max(0,helper(node.right));
      
     ans  = Math.max(ans , ls + rs + node.val);
     
     return node.val + Math.max(ls,rs);

    }
    public int maxPathSum(TreeNode root) {

        helper(root);
        return ans;
    }
}