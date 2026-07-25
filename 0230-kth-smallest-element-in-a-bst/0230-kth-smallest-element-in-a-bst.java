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
    int ans = -1;
    int n = 0;
    void helper(TreeNode node, int k){
         if(node == null){
            return;
         }

     helper(node.left,k);
        n++;
        if(n == k){
            ans = node.val;
        }
      helper(node.right,k);
       
    }

    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return ans;
    }
}