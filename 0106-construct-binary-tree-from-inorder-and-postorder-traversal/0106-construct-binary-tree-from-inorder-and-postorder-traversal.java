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
    TreeNode helper(int[] inorder,int instart, int inend, int[] postorder,int poststart,int postend){

        if (instart > inend || poststart > postend) return null;
       TreeNode root = new TreeNode(postorder[postend]);
        int inRoot = mpp.get(root.val);
        int rightNum = inend - inRoot;
        root.right = helper(inorder,inRoot + 1,inend,postorder,postend - rightNum,postend- 1);

 
        root.left = helper(inorder,instart,inRoot - 1,postorder,poststart,postend - rightNum - 1);
        return root;

   }
    


    Map<Integer,Integer> mpp = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i< inorder.length;i++){
            mpp.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
}