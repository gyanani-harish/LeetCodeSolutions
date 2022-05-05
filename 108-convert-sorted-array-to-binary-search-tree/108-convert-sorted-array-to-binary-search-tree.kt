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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return sortedArrayToBSTUtil(nums, 0, nums.size-1)
    }
    fun sortedArrayToBSTUtil(nums: IntArray, s: Int, e: Int): TreeNode?{
        if(s>e){
            return null
        }
        val mid = (s+e)/2
        val root: TreeNode = TreeNode(nums[mid])
        root.left = sortedArrayToBSTUtil(nums, s, mid-1)
        root.right =sortedArrayToBSTUtil(nums, mid+1, e)
        return root;
    }
}