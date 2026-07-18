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
     List<String> ans  = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    void helper(TreeNode node){
        int len = sb.length();
        sb.append(String.valueOf(node.val));
        
        if(node.right == null && node.left == null){
            ans.add(sb.toString());
            sb.setLength(len);
            return;
        }


        sb.append("->");
        if(node.left != null){
            helper(node.left);
        }
    
        if(node.right != null){
            helper(node.right);
        }
      sb.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
             if(root == null) return ans;
    helper(root);
    return ans;
    }
}