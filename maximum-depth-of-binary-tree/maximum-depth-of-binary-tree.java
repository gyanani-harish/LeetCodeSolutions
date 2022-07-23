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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return maxDepth(root, 1 ,1);
    }
    public int maxDepth(TreeNode root, int level, int maxLevel){
        if(root == null){
            return maxLevel;
        }
        if(level>maxLevel){
            maxLevel = level;
        }
        return Math.max(maxDepth(root.left, level+1, maxLevel),maxDepth(root.right, level+1, maxLevel));
    }
}