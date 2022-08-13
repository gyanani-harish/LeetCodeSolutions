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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode pNode = q.poll();
                TreeNode temp = pNode.left;
                pNode.left = pNode.right;
                pNode.right = temp;
                if(pNode.left!=null){
                    q.add(pNode.left);
                }
                if(pNode.right!=null){
                    q.add(pNode.right);
                }
            }
        }
        return root;
    }
}