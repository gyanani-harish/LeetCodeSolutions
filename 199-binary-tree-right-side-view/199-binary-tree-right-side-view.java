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
        //7:03
        return usingLevelOrder(root);
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
    /*public List<Integer> usingReversePreOrder(){
        
    }*/
}