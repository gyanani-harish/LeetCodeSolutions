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
    public List<Integer> postorderTraversal(TreeNode root) {
        return withLoop(root);
    }
    private List<Integer> withLoop(TreeNode root){
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> ansList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> isVisited = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode polledNode = stack.peek();
            if((polledNode.left!=null && !isVisited.contains(polledNode.left)) || (polledNode.right!=null  && !isVisited.contains(polledNode.right)) ){
                //stack.push(polledNode);
                if(polledNode.right!=null){
                    stack.push(polledNode.right);
                }
                if(polledNode.left!=null){
                    stack.push(polledNode.left);
                }
            } else {
                stack.pop();
                isVisited.add(polledNode);
                ansList.add(polledNode.val);
            }
        }
        return ansList;
    }
}