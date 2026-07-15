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
    int  helper(TreeNode node,List<Integer>ans){
        if(node == null){
            return 0;
        }
        int l = helper(node.left,ans);
        int r = helper(node.right,ans);
        ans.set(0,Math.max(l+r,ans.get(0))) ;

        return 1 + Math.max(l,r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      ans.add(0);
        helper(root,ans);
        return ans.get(0);
    }
}