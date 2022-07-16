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
    public List<Integer> preorderTraversal2(TreeNode root) {
        //with recursion
        List<Integer> answerList = new ArrayList<>();
        if(root == null){ 
            return new ArrayList<>();
        }
        answerList.add(root.val);
        List<Integer> leftList = preorderTraversal(root.left);
        if(leftList.size()>0){
            answerList.addAll(leftList);
        }
        List<Integer> rightList = preorderTraversal(root.right);
        if(rightList.size()>0){
            answerList.addAll(rightList);
        }
        return answerList;
    }
    public List<Integer> preorderTraversal3(TreeNode root) {
        //with recursion but save addAll call
        return preorderTraversalSaveAddAll(root, new ArrayList<Integer>());
    }
    public List<Integer> preorderTraversalSaveAddAll(TreeNode root, List<Integer> ansList){
        if(root == null){
            return ansList;
        }
        ansList.add(root.val);
        preorderTraversalSaveAddAll(root.left, ansList);
        preorderTraversalSaveAddAll(root.right, ansList);
        return ansList;
    }
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        //with loop
        List<Integer> ansList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> isVisited = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode polledNode = stack.pop();
            if(polledNode == null){
                continue;
            }
            if(!isVisited.contains(polledNode)){
                ansList.add(polledNode.val);
                isVisited.add(polledNode);
            }
            if(polledNode.right!=null){
                stack.push(polledNode.right);
            }
            if(polledNode.left!=null){
                stack.push(polledNode.left);
            }
        }
        
        return ansList;
    }
}