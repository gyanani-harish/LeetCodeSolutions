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
    public int maxPathSum(TreeNode root) {
        //check sum of both child and choose one
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }
    public int maxPathSum(TreeNode root, int[] max) {
        
       //  if(root == null){
       //      return 0;
       //  }
       //  int leftTreeSum = Math.max(maxPathSum(root.left),0);
       //  int rightTreeSum = Math.max(maxPathSum(root.right),0);
       //  int currentTreeSum = root.val+leftTreeSum+rightTreeSum;
       //  max[0] = Math.max(max[0], currentTreeSum);
       //  //check sum of both child and choose one
       // return root.val + Math.max(leftTreeSum, rightTreeSum);
        if (root == null)
      return 0;

    final int l = Math.max(maxPathSum(root.left, max), 0);
    final int r = Math.max(maxPathSum(root.right, max), 0);
    max[0] = Math.max(max[0], root.val + l + r);
    return root.val + Math.max(l, r);
    }
}