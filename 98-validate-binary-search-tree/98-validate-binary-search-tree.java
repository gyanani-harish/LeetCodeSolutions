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
    public boolean isValidBST(TreeNode root) {
        //6:51 pm
        return isValidBST(root, new AtomicInteger(Integer.MIN_VALUE), new AtomicBoolean(false));
    }
    public boolean isValidBST(TreeNode root, AtomicInteger lastValue, AtomicBoolean isSet) {
        if(root == null){
            return true;
        }
        boolean leftRes = isValidBST(root.left, lastValue, isSet);
        if(leftRes == false){
            return false;
        }
        if(root.val>lastValue.get()){

        } else if(!isSet.get()){

        } else {
            return false;
        }
        lastValue.set(root.val);
        isSet.set(true);
        boolean rightRes = isValidBST(root.right, lastValue, isSet);
        if(rightRes == false){
            return false;
        }
        return true;
    }
}