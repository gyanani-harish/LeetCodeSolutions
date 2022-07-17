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
    public boolean evaluateTree(TreeNode root) {
        if(root == null){
            return false;
        }
        boolean leftRes=false, rightRes=false;
        if(root.left!=null){
            leftRes = evaluateTree(root.left);
        }
        if(root.right!=null){
            rightRes = evaluateTree(root.right);
        }
        if(root.left == null && root.right==null){
            return root.val == 1 ? true : false;
        }
        return root.val == 2 ? leftRes || rightRes : leftRes && rightRes;
    }
}