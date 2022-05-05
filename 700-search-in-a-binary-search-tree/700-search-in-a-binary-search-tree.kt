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
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null){
            return root
        }
        if(root.`val`== `val`){
            return root;
        }
        var answer = searchBST(root.left, `val`)
        if(answer != null){
            return answer
        }
        return searchBST(root.right, `val`)
        
    }
}