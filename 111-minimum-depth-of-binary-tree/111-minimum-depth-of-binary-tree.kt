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
    fun minDepth(root: TreeNode?): Int {
         if(root == null) return 0
        val left = minDepth(root.left)
        val right = minDepth(root.right)
        if(left == 0 || right == 0){
            return left + right + 1
        } else {
            return Math.min(left,right) + 1
        }
    }
    
}