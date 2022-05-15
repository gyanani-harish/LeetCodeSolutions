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
import java.util.*
import java.util.AbstractMap.SimpleEntry

class Solution {
     fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val ans = TreeMap<Int, LinkedList<Pair<Int, Int>>>()
        verticalTraversalUtil(root, 0, 0, ans)
        return convert(ans)
    }

    private fun convert(input: TreeMap<Int, LinkedList<Pair<Int, Int>>>): List<List<Int>> {
        val output = LinkedList<List<Int>>()
        input.forEach {
            it.value.sortWith(object: Comparator<Pair<Int,Int>>{
                override fun compare(o1: Pair<Int, Int>, o2: Pair<Int, Int>): Int {
                    return if (o1.second == o2.second) {
                        o1.first - o2.first
                    } else {
                        o1.second - o2.second
                    }
                }
            })
            val list = LinkedList<Int>()
            for (item in it.value) {
                list.add(item.first)
            }
            output.add(list)
        }
        return output
    }

    private fun verticalTraversalUtil(
        root: TreeNode?,
        column: Int,
        row: Int,
        ansMap: TreeMap<Int, LinkedList<Pair<Int, Int>>>
    ) {
        if (root == null) {
            return
        }
        val nodeList = ansMap[column]
        if (nodeList == null) {
            val list = LinkedList<Pair<Int, Int>>()
            list.add(Pair(root.`val`, row))
            ansMap[column] = list
        } else {
            nodeList.add(Pair(root.`val`, row))
        }
        verticalTraversalUtil(root.left, column - 1, row + 1, ansMap)
        verticalTraversalUtil(root.right, column + 1, row + 1, ansMap)
    }
}