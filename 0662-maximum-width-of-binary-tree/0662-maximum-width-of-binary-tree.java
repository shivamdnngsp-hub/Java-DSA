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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
     Queue<Pair> q = new LinkedList<>();
     q.offer(new Pair(root,0));

     int max = Integer.MIN_VALUE;

     while(!q.isEmpty()){
        int size = q.size();
        int left = 0;
        int right = 0;
        for(int i = 0;i<size;i++){
            Pair p = q.remove();
            if(i == 0){
            left = p.index;
            }
            if(i == size-1){
                right = p.index;
            }
           
           if(p.node.left != null){
             q.offer(new Pair(p.node.left,2*p.index+1));
           }
           if(p.node.right != null){
            q.offer(new Pair(p.node.right,2*p.index+2));
           }
        }
        max = Math.max(max,right-left+1);
     }
     return max;
    }
}