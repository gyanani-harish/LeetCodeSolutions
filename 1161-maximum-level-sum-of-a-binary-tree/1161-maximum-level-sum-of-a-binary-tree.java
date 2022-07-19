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
    public int maxLevelSum(TreeNode root) {
        //go level by level, sum nodes, keep minimum and after traversal return value
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            while(size-->0){
                TreeNode polledNode = queue.poll();
                sum += polledNode.val;
                if(polledNode.left!=null){
                    queue.add(polledNode.left);
                }
                if(polledNode.right!=null){
                    queue.add(polledNode.right);
                }
            }
            if(sum>max){
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}