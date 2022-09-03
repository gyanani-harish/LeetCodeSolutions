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
    public TreeNode increasingBST(TreeNode root) {
        //use preorder 
        //keep in array or list
        List<TreeNode> list = new LinkedList<>();
        preorder(root, list);
        TreeNode newRoot = null;
        TreeNode ansBackup = null;
        //create right skewed tree
        for(TreeNode item : list){
            if(newRoot == null){
                newRoot = new TreeNode(item.val);
                ansBackup = newRoot;
            } else {
                newRoot.right = new TreeNode(item.val);
                newRoot = newRoot.right;
            }
        }
        return ansBackup;
    }
    private void preorder(TreeNode root, List list){
        //2
        //1,4
        //-1,-1,3, -1
        if(root == null){
            return;
        }
        preorder(root.left, list);
        list.add(root);
        preorder(root.right, list);
    }
}