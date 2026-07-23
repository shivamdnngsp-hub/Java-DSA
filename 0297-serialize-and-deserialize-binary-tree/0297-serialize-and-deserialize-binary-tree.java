/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
   
    List<String> l = new ArrayList<>();
    void helper(TreeNode node){
        if(node == null){
            l.add("#");
            return;
        }
        l.add(String.valueOf(node.val));
        helper(node.left);
        helper(node.right);
    }

    public String serialize(TreeNode root) {
       helper(root);
       return String.join(",",l);
    }
       
       int i = 0;
      TreeNode helper2(List<String> li){
        if(li.get(i).equals("#")){
            i++;
            return null;
        }
         TreeNode root = new TreeNode(Integer.parseInt(li.get(i)));
         i++;
         root.left = helper2(li);
         root.right = helper2(li);
         return root;
      }


    public TreeNode deserialize(String data) {
        List<String> li = Arrays.asList(data.split(","));
        return  helper2(li);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));