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
    public int minDepth(TreeNode root) {
        //BFS
        //go level by level, first leaf node found and return back with answer
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
       
        int level = 1;
        int minus = 0;
        while(!queue.isEmpty()){
            TreeNode node;
            int size = queue.size();
            for(int i =0;i<size;i++){
                node = queue.poll();
                if(isLeafNode(node)){
                    return level;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            level++;
        }
        return -1;
    }
    private boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }
}