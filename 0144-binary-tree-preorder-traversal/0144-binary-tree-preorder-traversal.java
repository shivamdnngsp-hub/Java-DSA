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
    void preOrder(TreeNode node,List<Integer> l){
        if(node == null){
            return;
        }
        
        l.add(node.val);
        preOrder(node.left,l);
        preOrder(node.right,l);
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        preOrder(root,l);
        return l;
    }
}