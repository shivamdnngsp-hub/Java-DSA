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
    List<Integer> l = new ArrayList<>();
    void helper(TreeNode node){
        if(node == null){
            return;
        }

        helper(node.left);
        l.add(node.val);
        helper(node.right);

      return;
    }
    public boolean findTarget(TreeNode root, int k) {
        helper(root);
        int i = 0;
        int j = l.size() -1;
        while(i<j){
            if(l.get(i) + l.get(j) == k){
                return true;
            }else if(l.get(i) + l.get(j)>k){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}