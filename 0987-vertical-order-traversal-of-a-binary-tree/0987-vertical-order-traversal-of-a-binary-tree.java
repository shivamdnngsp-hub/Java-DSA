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
    Map<Integer, List<ob>> mpp = new TreeMap<>();

    class ob {
        TreeNode node;
        int row;
        int col;

        ob(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    void helper(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        helper(node.left, row + 1, col - 1);
        mpp.putIfAbsent(col, new ArrayList<>());
        mpp.get(col).add( new ob(node, row, col));
        helper(node.right, row + 1, col + 1);

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root,0,0);
        List<List<Integer>>  ans = new ArrayList<>();
        for (int  key : mpp.keySet()) {
            List<ob> L = mpp.get(key);
          Collections.sort(L, (a, b) -> {
          if (a.row != b.row) {
             return Integer.compare(a.row, b.row);
           }
             return Integer.compare(a.node.val, b.node.val);
             }
             );
           List<Integer> ll = new ArrayList<>();
             for(ob ele : L){
                ll.add(ele.node.val);
             }
             ans.add(ll);

        }

        
return ans;
}
}