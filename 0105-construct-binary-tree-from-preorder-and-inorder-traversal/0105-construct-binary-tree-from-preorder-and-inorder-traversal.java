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
    TreeNode helper(int[] preorder,int preStart,int preEnd, int[] inorder, int inStart,int inEnd){

        if(preEnd < preStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inroot = mpp.get(root.val);
        int numleft = inroot - inStart;

        root.left = helper(preorder,preStart+1,preStart+numleft,inorder,inStart,inroot-1);
        root.right = helper(preorder,preStart + numleft +1, preEnd,inorder,inroot+1,inEnd);
      return root;
    }

    HashMap<Integer,Integer> mpp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i< inorder.length;i++){
          mpp.put(inorder[i],i);
        }

        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length -1);
    }
}