/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
    fun sortedListToBST(head: ListNode?): TreeNode? {
        val arrayList = mutableListOf<Int>()
        var myIterator = head 
        while(myIterator != null){
            arrayList.add(myIterator.`val`)
            myIterator = myIterator.next
        }
        return sortedListToBST(arrayList, 0, arrayList.size-1)
    }
    fun sortedListToBST(arrayList: MutableList<Int>, s: Int, e: Int):TreeNode?{
        if(s>e){
            return null;
        }
        val mid = (s+e)/2
        val root = TreeNode(arrayList[mid])
        root.left = sortedListToBST(arrayList, s, mid-1)
        root.right = sortedListToBST(arrayList, mid+1, e)
        return root
    }
    
}