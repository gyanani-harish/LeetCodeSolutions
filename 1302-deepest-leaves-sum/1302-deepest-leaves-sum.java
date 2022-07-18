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
    int highestLevel = 0;
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        deepestLeavesSum(root, 0, sumMap);
        return sumMap.get(highestLevel);
    }
    public void deepestLeavesSum(TreeNode root, int level, Map<Integer, Integer> sumMap){
        if(root == null){
            return;
        }
        highestLevel = Math.max(highestLevel, level);
        if(root.left!=null){
            deepestLeavesSum(root.left, level+1, sumMap);
        }
        if(root.right!=null){
            deepestLeavesSum(root.right, level+1, sumMap);
        }
        if(isLeafNode(root) && level==highestLevel){
            int alreadySum = sumMap.getOrDefault(level, 0);
            sumMap.clear();
            sumMap.put(level, alreadySum+root.val);
        }
    }
    private boolean isLeafNode(TreeNode root){
        return root.left == null && root.right==null;
    }
}