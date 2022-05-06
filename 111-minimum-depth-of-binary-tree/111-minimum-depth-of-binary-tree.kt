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
    fun minDepth2(root: TreeNode?): Int {
         if(root == null) return 0
        val left = minDepth(root.left)
        val right = minDepth(root.right)
        if(left == 0 || right == 0){
            return left + right + 1
        } else {
            return Math.min(left,right) + 1
        }
    }
    fun minDepth(root: TreeNode?): Int {
        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        var level = 1
        while(!queue.isEmpty()){
            val size = queue.size
            for(i in 0..size-1){
                val node = queue.poll();
                if(isLeafNode(node)){
                    return level
                }
                node?.left?.let {
                    queue.add(it)
                }
                node?.right?.let{
                    queue.add(it)
                }
            }
            level++
        }
        return 0
    }
    fun isLeafNode(node: TreeNode?): Boolean {
        node?.let{
            return node.left == null && node.right == null
        }
        return false
    }
}