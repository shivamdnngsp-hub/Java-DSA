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

  void inOrder(TreeNode node,List<Integer> l){
        if(node == null){
            return;
        }

        inOrder(node.left,l);
        l.add(node.val);
        inOrder(node.right,l);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> l = new ArrayList<>();
        inOrder(root,l);
        return l;
    }
}