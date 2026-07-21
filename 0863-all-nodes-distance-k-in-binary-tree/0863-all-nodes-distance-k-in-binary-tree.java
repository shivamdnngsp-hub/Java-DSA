/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q  = new LinkedList<>();
        HashMap<TreeNode,TreeNode> mpp = new HashMap<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size  = q.size();
            for(int i = 0;i<size;i++){
                TreeNode node = q.remove();
                 if(node.left != null){
                   mpp.put(node.left,node);
                   q.offer(node.left);
                 }
                 if(node.right != null){
                   mpp.put(node.right,node);
                   q.offer(node.right);
                 }
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        q.offer(target);
        int dis = 0;
        while(!q.isEmpty()){
            if(dis == k){
                break;
            }
            int size = q.size();

            for(int i = 0;i<size;i++){


           TreeNode node = q.remove();
           if(node.left != null && !visited.contains(node.left)){
                   q.offer(node.left);
                   visited.add(node.left);
            }
            if(node.right != null && !visited.contains(node.right)){
                   q.offer(node.right);
                   visited.add(node.right);
            }
            if(mpp.containsKey(node) && !visited.contains(mpp.get(node))){
                q.offer(mpp.get(node));
                visited.add(mpp.get(node));
            }

            }

          dis++;
        }

List<Integer> ans = new ArrayList<>();
while(!q.isEmpty()){
    ans.add(q.remove().val);
}


return ans;
        
    }
}