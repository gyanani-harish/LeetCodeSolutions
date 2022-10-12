class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        return binarySearch(nums, target, 0, nums.size - 1)
    }

    private fun binarySearch(nums: IntArray, target: Int, _low: Int, _high: Int): IntArray {
        //println("Window search $_low and $_high")
        var low = _low
        var high = _high
        val resultSet = IntArray(2,{ -1 })
        while (low <= high) {
            val midIndex = (low + high) / 2
            if (nums[midIndex] == target) {
                if(midIndex<resultSet[0] || resultSet[0] == -1){
                    resultSet[0] = midIndex
                }
                if(midIndex>resultSet[1]){
                   resultSet[1] = midIndex
                }
                if (low <= midIndex - 1 && nums[midIndex - 1] == target && (!resultSet.contains(midIndex - 1) || !resultSet.contains(
                        low
                    ))
                ) {
                    val result = binarySearch(nums, target, low, midIndex - 1)
                    if(result[0]!=-1 && (result[0]<resultSet[0] || resultSet[0] == -1)){
                        resultSet[0] = result[0]
                    }
                    if(result[1]>resultSet[1]){
                        resultSet[1] = result[1]
                    }
                }
                if (midIndex + 1 <= high && nums[midIndex + 1] == target && (!resultSet.contains(midIndex + 1) || !resultSet.contains(
                        high
                    ))
                ) {
                    val result = binarySearch(nums, target, midIndex + 1, high)
                    if(result[0]!=-1 && (result[0]<resultSet[0] || resultSet[0] == -1)){
                        resultSet[0] = result[0]
                    }
                    if(result[1]>resultSet[1]){
                        resultSet[1] = result[1]
                    }
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