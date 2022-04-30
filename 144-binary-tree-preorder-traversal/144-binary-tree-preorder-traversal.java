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
    public List<Integer> preorderTraversal(TreeNode root) {
        /*
        inOrder without visited set
        List<Integer> answer = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            if(root == null){
                root = stack.pop();
            }
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            answer.add(root.val);
            
            root = root.right;
        }*/
        List<Integer> answer = new LinkedList<>();
        if(root == null){
            return answer;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr == null){
                continue;
            }
            answer.add(curr.val);
            if(curr.right!=null){
                stack.push(curr.right);
            }
            if(curr.left!=null){
                stack.push(curr.left);
            }
        }
        return answer;
    }
}