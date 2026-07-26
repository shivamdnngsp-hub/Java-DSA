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
    int i = 0;
    TreeNode helper(int[] preorder,int min,int max){

        if(i>preorder.length-1 ||preorder[i]<=min || preorder[i]>= max){
            return null;
        }


    TreeNode root = new TreeNode(preorder[i]);
    i++;
    root.left = helper(preorder,min,root.val);
    root.right = helper(preorder,root.val,max);
    
     return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}