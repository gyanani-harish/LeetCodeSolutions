class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        return binarySearch(nums, target, 0, nums.size - 1)
    }

    private fun setResult(nums: IntArray, target: Int, midIndex: Int, resultSet: IntArray): Boolean {
        if (midIndex < 0 || midIndex > nums.size - 1) {
            return false
        }
        if(nums[midIndex] != target){
            return false
        }
        var result = false
        if (midIndex < resultSet[0] || resultSet[0] == -1) {
            resultSet[0] = midIndex
            result = true
        }
        if (midIndex > resultSet[1]) {
            resultSet[1] = midIndex
            result = true
        }
        return result
    }
    
    private fun binarySearch(nums: IntArray, target: Int, _low: Int, _high: Int): IntArray {
        //println("Window search $_low and $_high")
        var low = _low
        var high = _high
        if(nums[low] == target && nums[high] == target){
            return intArrayOf(low, high)
        }
        val resultArr = IntArray(2, { -1 })
        while (low <= high) {
            val midIndex = (low + high) / 2
            if (nums[midIndex] == target) {
                val isAddedMin = setResult(nums, target, midIndex - 1, resultArr)
                val isAddedMax = setResult(nums, target, midIndex + 1, resultArr)
                if (!isAddedMin || !isAddedMax) {
                    setResult(nums, target, midIndex, resultArr)
                }
                val lowIndex = midIndex - 2
                val maxIndex = midIndex + 2
                if (low <= lowIndex && nums[lowIndex] == target) {
                    val result = binarySearch(nums, target, low, lowIndex)
                    if (result[0] != -1 && (result[0] < resultArr[0] || resultArr[0] == -1)) {
                        resultArr[0] = result[0]
                    }
                    if (result[1] > resultArr[1]) {
                        resultArr[1] = result[1]
                    }
                }
                if (maxIndex <= high && nums[maxIndex] == target) {
                    val result = binarySearch(nums, target, maxIndex, high)
                    if (result[0] != -1 && (result[0] < resultArr[0] || resultArr[0] == -1)) {
                        resultArr[0] = result[0]
                    }
                    if (result[1] > resultArr[1]) {
                        resultArr[1] = result[1]
                    }
                }
                return resultArr
            } else if (nums[midIndex] < target) {
                low = midIndex + 1
            } else {
                high = midIndex - 1
            }
        }
        return resultArr
    }
}