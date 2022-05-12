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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean result = isBalanced(root.left) && isBalanced(root.right);
        if(!result){
            return false;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight-rightHeight)<=1;
    }
    private int getHeight(TreeNode root){
        if(root== null){
            return 0;
        }
        return Math.max(getHeight(root.left)+1, getHeight(root.right)+1);
    }
}