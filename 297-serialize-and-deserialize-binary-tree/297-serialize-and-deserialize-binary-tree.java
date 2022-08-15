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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode polledNode = q.poll();
                if(polledNode == null){
                    sb.append("null");
                    sb.append(" ");
                    continue;
                }
                sb.append(polledNode.val);
                sb.append(" ");
                q.add(polledNode.left);
                q.add(polledNode.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)){
            return null;
        }
        String[] split = data.split(" ");
        int parentIndex = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        TreeNode rootBackup = root;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                root = q.poll();
                int leftIndex = parentIndex*2+1;
                int rightIndex = parentIndex*2+2;
                if(leftIndex<split.length && !("null".equals(split[leftIndex]))){
                    root.left = new TreeNode(Integer.parseInt(split[leftIndex]));
                    q.add(root.left);
                }
                if(rightIndex<split.length && !("null".equals(split[rightIndex]))){
                    root.right = new TreeNode(Integer.parseInt(split[rightIndex]));
                    q.add(root.right);
                }
                parentIndex++;
            }
        }
        return rootBackup;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));