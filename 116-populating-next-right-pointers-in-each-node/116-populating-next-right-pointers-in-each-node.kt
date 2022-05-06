/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if(root == null){
            return null
        }
        val queue: Queue<Node?> = LinkedList<Node?>()
        queue.add(root)
        while(!queue.isEmpty()){
            val size = queue.size;
            for(i in 0..size-1){
                val node = queue.poll()
                node?.left?.let{
                    queue.add(node.left)
                }
                node?.right?.let{
                    queue.add(node.right)
                }
            }
            val tempQueue : Queue<Node?> = LinkedList<Node?>(queue)
            var node = tempQueue.poll()
            while(!tempQueue.isEmpty()){
                node?.let{
                    it.next = tempQueue.poll()
                    node = it.next
                }
            }
        }
        return root
    }
}