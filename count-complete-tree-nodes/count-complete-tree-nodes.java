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
    public int countNodes(TreeNode root) {
        return countNodesUtil(root);
    }
    private int countNodesUtil(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getTreeHeight(root.left, true);
        int rightHeight = getTreeHeight(root.right, false);
        
        if(leftHeight == rightHeight){
            return (int) Math.pow(2, leftHeight+1) - 1;
        } else {
            return 1+countNodesUtil(root.left) + countNodesUtil(root.right);
        }
    }
    private int getTreeHeight(TreeNode node, boolean isLeft) {
        int height = 0;
        while (node != null) {
            height++;
            node = isLeft?node.left:node.right; // Only traverse left to get height
        }
        return height;
    }
}