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
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, k, new AtomicInteger(1));
    }
    public Integer kthSmallest(TreeNode root, int k, AtomicInteger current){
        if(root == null){
            return null;
        }
        Integer leftRes = kthSmallest(root.left, k, current);
        if(leftRes != null){
            return leftRes;
        }
        if(current.get() == k){
            return root.val;
        } else {
            current.set(current.get()+1);
        }
        Integer rightRes = kthSmallest(root.right, k, current);
        if(rightRes != null){
            return rightRes;
        }
        return null;
    }
}