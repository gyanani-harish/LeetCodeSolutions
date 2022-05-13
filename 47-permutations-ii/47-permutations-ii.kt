class Solution {
    fun permuteUnique(arr: IntArray): List<List<Int>> {
        val res = HashSet<ArrayList<Int>>()
        permute(arr, 0, arr.size - 1, res)
        return ArrayList(res)
    }
    private fun permute(arr: IntArray, l: Int, r: Int, res: HashSet<ArrayList<Int>>) {
        if (l == r) {
            val a = arr.copyOfRange(0, arr.size).toList()
            if (a.size == 1) {
                res.add(ArrayList(a))
            } else {
                res.add(a as java.util.ArrayList<Int>)
            }
        } else {
            for (i in l..r) {
                swap(arr, l, i)
                permute(arr, l + 1, r, res)
                swap(arr, l, i)
            }
        }
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        if (i == j) {
            return
        }
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}