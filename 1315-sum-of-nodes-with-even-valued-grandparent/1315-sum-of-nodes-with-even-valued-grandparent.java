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
    static class TreeNodeWithParent {
        TreeNodeWithParent parent;
        int val;
        TreeNode left;
        TreeNode right;
        TreeNodeWithParent(TreeNode node, TreeNodeWithParent parent){
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
            this.parent = parent;
        }
        TreeNodeWithParent(TreeNode node){
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
            parent = null;
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null){
            return 0;
        }
        int total = 0;
        Queue<TreeNodeWithParent> queue = new LinkedList<>();
        queue.add(new TreeNodeWithParent(root));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNodeWithParent node = queue.poll();
                if(node.parent!=null && node.parent.parent!=null && (node.parent.parent.val&1)==0){
                    total+=node.val;
                }
                if(node.left!=null){
                    queue.add(new TreeNodeWithParent(node.left, node));
                }
                if(node.right!=null){
                    queue.add(new TreeNodeWithParent(node.right, node));
                }
            }
        }
        return total;
                //    6,
                //   7,8,
                // 2,7,1,3,
        //9,null,1,4,null,null,null,5
    }
}