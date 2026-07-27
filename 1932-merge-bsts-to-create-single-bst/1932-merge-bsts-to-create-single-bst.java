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
     Map<Integer,TreeNode> mpp = new HashMap<>();

     boolean helper(TreeNode node , int min, int max){
        if(node == null){
            return true;
        }

        if(node.val<=min || node.val>=max){
            return false;
        }

        if(node.left == null && node.right == null){
            if(mpp.containsKey(node.val) && mpp.get(node.val) != node){
                TreeNode m = mpp.get(node.val);
                node.left = m.left;
                node.right = m.right;
                mpp.remove(node.val);
            }
        }

 return helper(node.left,min,node.val) && helper(node.right,node.val,max);
     }

  
    public TreeNode canMerge(List<TreeNode> trees) {
       Set<Integer> s = new HashSet<>();
       for(TreeNode tree : trees){
        mpp.put(tree.val,tree);
        if(tree.left != null){
           s.add(tree.left.val);
       }
       if(tree.right != null){
          s.add(tree.right.val);
       }
       }
       TreeNode root = null;
       for(TreeNode tree : trees){
        if(mpp.containsKey(tree.val) && !s.contains(tree.val)){
            if(root != null){
                return null;
            }
            root = tree;
        }
       }
       if(root == null) return null;

       if(!helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
        return null;
       }

 if (mpp.size() != 1) return null;

return root;
    }
}