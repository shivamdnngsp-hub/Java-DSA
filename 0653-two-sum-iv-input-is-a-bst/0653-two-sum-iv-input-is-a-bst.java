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

        Stack<TreeNode> st2 = new Stack<>();
        Stack<TreeNode> st1 = new Stack<>();



    TreeNode nextl(){
     TreeNode node = st1.pop();
     if(node.right != null){
        TreeNode right = node.right;
        while(right != null){
            st1.push(right);
            right = right.left;
        }
     }
     return node;
    }


     TreeNode nextr(){
     TreeNode node = st2.pop();
     if(node.left != null){
        TreeNode left = node.left;
        while(left != null){
            st2.push(left);
            left  = left.right;
        }
     }
     return node;
    }

    public boolean findTarget(TreeNode root, int k) {
        TreeNode node = root;
        while(node != null){
            st1.push(node);
            node = node.left;
        }
        node = root;
        while(node != null){
            st2.push(node);
            node = node.right;
        }
int left = nextl().val;
int right =  nextr().val;

while (left < right) {
    int sum = left + right;
    if (sum == k){
        return true;
    }else if (sum < k){
        left = nextl().val;
    }else{
         right = nextr().val;  
    }
           
}


return false;
    }
}