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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.val == targetSum && root.left==null && root.right==null){
            return true;
        }
        boolean leftAns = hasPathSum(root.left, targetSum-root.val);
        if(leftAns){
            return true;
        }
        boolean rightAns = hasPathSum(root.right, targetSum-root.val);
        if(rightAns){
            return true;
        }
        targetSum+=root.val;
        return false;
    }
}