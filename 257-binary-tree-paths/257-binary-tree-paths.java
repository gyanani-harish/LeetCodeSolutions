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
    public List<String> binaryTreePaths(TreeNode root) {
        return convert(binaryTreePathsUtil(root));
    }

    public List<String> convert(List<List<Integer>> list) {
        System.out.println(list);
        List<String> ls = new LinkedList<>();
        for(List<Integer> l : list){
            Collections.reverse(l);
            StringBuilder sb = new StringBuilder();
            for(Integer i : l){
                sb.append(i);
                sb.append("->");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            ls.add(sb.toString());
        }
        return ls;
    }

    public List<List<Integer>> binaryTreePathsUtil(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        if (isLeafNode(root)) {
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            List<List<Integer>> fList = new LinkedList<>();
            fList.add(list);
            return fList;
        }

        List<List<Integer>> finalList = new LinkedList<>();

        List<List<Integer>> leftList = binaryTreePathsUtil(root.left);
        List<List<Integer>> rightList = binaryTreePathsUtil(root.right);

        if (leftList != null && !leftList.isEmpty()) {
            for(List<Integer> list : leftList) {
                list.add(root.val);
            }
            finalList.addAll(leftList);
        }

        if (rightList != null && !rightList.isEmpty()) {
            for(List<Integer> list : rightList) {
                list.add(root.val);
            }
            finalList.addAll(rightList);
        }

        return finalList;
    }

    private boolean isLeafNode(TreeNode node) {
        if (node != null && node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}