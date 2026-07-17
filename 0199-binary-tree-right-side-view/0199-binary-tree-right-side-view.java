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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> mpp = new TreeMap<>();
        if(root == null) return ans;
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
      
       while(!q.isEmpty()){
          
         int size = q.size();
         int last = 0;
         for(int i = 0;i<size;i++){
            TreeNode node = q.remove();
             last = node.val;
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
         }
         ans.add(last);
       }

return ans;
    }
}