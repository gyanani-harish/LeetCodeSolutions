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
    public List<Integer> rightSideView(TreeNode root) {
        //7:03 - 7:10
        //return usingLevelOrder(root);
        //7:11 - 
        return usingReversePreOrder(root, 0, new ArrayList<Integer>());
    }
    public List<Integer> usingLevelOrder(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode pNode = q.poll();
                if(pNode.left!=null){
                    q.add(pNode.left);
                }
                if(pNode.right!=null){
                    q.add(pNode.right);
                }
                if(size == 0){
                    result.add(pNode.val);
                }
            }
        }
        return result;
    }
    public List<Integer> usingReversePreOrder(TreeNode root, int level, List<Integer> result){
        if(root == null){
            return result;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        usingReversePreOrder(root.right, level+1, result);
        usingReversePreOrder(root.left, level+1, result);
        return result;
    }
}