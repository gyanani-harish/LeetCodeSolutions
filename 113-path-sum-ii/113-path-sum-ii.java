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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        allPaths(root, new ArrayList<>(), 0, ans, targetSum);
        return ans;
    }
    public void allPaths(TreeNode root, List<Integer> current, int currentSum, List<List<Integer>> allPaths, int targetSum) {
        if (root == null) {
            return;
        }
        if (isLeafNode(root)) {
            List<Integer> temp = new ArrayList<>(current);
            temp.add(root.val);
            if(currentSum+root.val == targetSum) {
                allPaths.add(temp);
            }
            return;
        }

        current.add(root.val);
        currentSum += root.val;
        if (root.left != null) {
            allPaths(root.left, current, currentSum, allPaths, targetSum);
        }

        if (root.right != null) {
            allPaths(root.right, current, currentSum, allPaths, targetSum);
        }
        
        currentSum -= current.get(current.size() - 1);
        current.remove(current.size()-1);
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}