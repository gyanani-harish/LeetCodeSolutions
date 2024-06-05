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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //traverse(root1);
        return compare(root1, root2);
    }
    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        traverse(root.left);
        traverse(root.right);
    }
    private boolean compare(TreeNode root1, TreeNode root2){
        if(root1 == null && root2==null){
            return true;
        }
        if(root1 == null && root2 !=null){
            return false;
        }
        if(root1 != null && root2 ==null){
            return false;
        }
        return root1.val == root2.val 
            && (
            (compare(root1.left, root2.left) && compare(root1.right, root2.right))
            || 
            (compare(root1.right, root2.left) && compare(root1.left, root2.right))
        );
    }
}