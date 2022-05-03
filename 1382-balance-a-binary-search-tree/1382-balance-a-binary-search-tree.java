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
    public TreeNode balanceBST(TreeNode root) {
        //traverse using inorder and make a linkedList, which is sorted
        List<Integer> sortedList = new LinkedList<Integer>();
        inorder(root, sortedList);
        
        return createBST(sortedList, 0, sortedList.size()-1);
    }
    private void inorder(TreeNode root, List<Integer> list){
        if(root== null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    private TreeNode createBST(List<Integer> list, int start, int end){
        if(start>end){
            return null;//leaf node child
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(list.get(mid), createBST(list, start, mid-1), createBST(list, mid+1, end));
        return root;
    }
}