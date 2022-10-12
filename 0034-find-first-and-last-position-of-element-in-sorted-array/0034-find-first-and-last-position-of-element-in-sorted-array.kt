class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        val result = binarySearch(nums, target, 0, nums.size - 1)
        val iterator = result.iterator()
        var l = -1
        var r = -1
        while (iterator.hasNext()) {
            if (l == -1) {
                l = iterator.next()
            }
            r = if (iterator.hasNext()) iterator.next() else l
        }
        return intArrayOf(l, r)
    }

    private fun binarySearch(nums: IntArray, target: Int, _low: Int, _high: Int): Set<Int> {
        var low = _low
        var high = _high
        val resultSet: MutableSet<Int> = TreeSet()
        while (low <= high) {
            val midIndex = (low + high) / 2
            if (nums[midIndex] == target) {
                resultSet.add(midIndex)
                if (low <= midIndex - 1 && nums[midIndex - 1] == target && (!resultSet.contains(midIndex - 1) || !resultSet.contains(
                        low
                    ))
                ) {
                    resultSet.addAll(binarySearch(nums, target, low, midIndex - 1))
                }
                if (midIndex + 1 <= high && nums[midIndex + 1] == target && (!resultSet.contains(midIndex + 1) || !resultSet.contains(
                        high
                    ))
                ) {
                    resultSet.addAll(binarySearch(nums, target, midIndex + 1, high))
                }
                return resultSet
            } else if (nums[midIndex] < target) {
                low = midIndex + 1
            } else {
                high = midIndex - 1
            }
        }
        return resultSet
    }
}