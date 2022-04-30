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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();
        if(root == null){
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count;
        while(!queue.isEmpty()){
            count = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i =0;i<count;i++){
                TreeNode curr = queue.poll();
                if(curr!=null){
                    list.add(curr.val);
                    if(curr.left!=null){
                        queue.add(curr.left);
                    }
                    if(curr.right!=null){
                        queue.add(curr.right);
                    }
                }
            }
            answer.add(list);
        }
        Collections.reverse(answer);
        return answer;
    }
}