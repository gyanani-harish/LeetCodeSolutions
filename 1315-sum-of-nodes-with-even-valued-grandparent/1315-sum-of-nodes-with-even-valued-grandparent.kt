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
    fun sumEvenGrandparent(root: TreeNode?): Int {
        if(root == null){
            return 0
        }
        var total = 0
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        while(!queue.isEmpty()){
            
            val size = queue.size
            for(i in 0 until size){
                val node = queue.poll()
                if(node == null){
                    continue
                }
                val isNodeEven = (node.`val` and 1)==0
                if(node.left!=null){
                    queue.add(node.left)
                    if(isNodeEven){
                        if(node?.left?.left != null){
                            total += node.left.left.`val`
                        }
                        if(node?.left?.right != null){
                            total += node.left.right.`val`
                        }
                    }
                }
                if(node.right!=null){
                    queue.add(node.right)
                    if(isNodeEven){
                        if(node?.right?.left != null){
                            total += node.right.left.`val`
                        }
                        if(node?.right?.right != null){
                            total += node.right.right.`val`
                        }
                    }
                }
            }
        }
        return total
    }
}