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
    TreeNode helper(int[] preorder,int start,int end){
        if(start>end) return  null;

        TreeNode root = new TreeNode(preorder[start]);
        int left  = start;
        while(left<end){
            if(preorder[left+1]<preorder[start]){
                left++;
            }else{
                break;
            }
        }


        root.left = helper(preorder,start+1,left);
        root.right = helper(preorder,left+1,end);
     return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
}