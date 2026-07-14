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
      void postOrder(TreeNode node,List<Integer> l){
        if(node == null){
            return;
        }

        postOrder(node.left,l);
        postOrder(node.right,l);
        l.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer> l = new ArrayList<>();
        postOrder(root,l);
        return l;
    }
}