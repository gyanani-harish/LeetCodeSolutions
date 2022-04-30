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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //with queue
        List<List<Integer>> answer = new LinkedList<>();
        if(root == null){
            return answer;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //boolean anyRightValue=false;
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
                    //if(curr.left!=null || curr.right!=null){
                    //    anyRightValue=true;
                    //}
                }
            }
            answer.add(list);
            //if(anyRightValue == false){
            //    break;
            //}
            //anyRightValue = false;
        }
        return answer;
    }
    static class MyPair{
        TreeNode node;
        int level;
        MyPair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrderWithStack(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();
        if(root == null){
            return answer;
        }
        int level = 0;
        Stack<MyPair> stack = new Stack<>();
        stack.push(new MyPair(root, level));
        while(!stack.isEmpty()){
            MyPair curr = stack.pop();
            level = curr.level;
            if(answer.size()>level){
                List<Integer> list = answer.get(level);
                list.add(curr.node.val);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(curr.node.val);
                answer.add(list);
            }
            if(curr.node.right!=null){
                stack.push(new MyPair(curr.node.right, curr.level+1));
            }
            if(curr.node.left!=null){
                stack.push(new MyPair(curr.node.left, curr.level+1));
            }
        }
        return answer;
    }
}