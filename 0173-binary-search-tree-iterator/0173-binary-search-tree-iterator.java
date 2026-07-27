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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    TreeNode node;
    public BSTIterator(TreeNode root) {
        this.node = root;
        goLeft();
    }
   void goLeft() {
    while (node != null) {
        st.push(node);
        node = node.left;
    }
  }
    
    public int next() {
        TreeNode nex = st.pop();
        if(nex.right != null){
            node = nex.right;
            goLeft();
        }
        return nex.val;
    }
    
    public boolean hasNext() {
        if(st.isEmpty()){
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */