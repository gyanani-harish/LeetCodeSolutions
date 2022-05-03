/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val list = mutableListOf<Int>()
        inorder(root, list);
        return createBST(list, 0, list.size - 1);
    }

    private fun inorder(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(
            root.`val`
        );
        inorder(root.right, list);
    }

    private fun createBST(list: MutableList<Int>, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null;//leaf node child
        }
        val mid = (start + end) / 2;
        val root = TreeNode(list[mid])
        root.left = createBST(list, start, mid - 1)
        root.right = createBST(list, mid + 1, end)
        return root;
    }
}