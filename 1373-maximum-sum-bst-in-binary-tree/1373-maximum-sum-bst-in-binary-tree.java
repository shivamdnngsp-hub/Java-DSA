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

class obj{
    boolean isbst;
    int sum;
    int max;
    int min;
    obj(boolean isbst,int sum,int min,int max){
        this.isbst = isbst;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}

class Solution {
    int ans = 0;

    obj helper(TreeNode node){
       if(node == null){
          return new obj(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
       }

obj left = helper(node.left);
obj right = helper(node.right);

if (left.isbst && right.isbst &&node.val > left.max &&node.val < right.min) {
    int sum = left.sum + right.sum + node.val;
    ans = Math.max(ans, sum);
    return new obj(true,sum,Math.min(left.min, node.val),Math.max(right.max, node.val));
}

return new obj(false,0,0,0);
    }


    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
}