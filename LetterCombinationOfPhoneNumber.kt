package backtracking

import java.util.*
import kotlin.collections.HashMap

class LetterCombinationOfPhoneNumber {
    fun letterCombinations(digits: String): List<String?> {
        val ans: LinkedList<String> = LinkedList<String>()
        if (digits.isEmpty()) return ans
        val mapping = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        ans.add("")
        val map: MutableMap<Int, Int> = HashMap<Int, Int>()
        map.put(1,2)
        for (i in digits.indices) {
            val x = Character.getNumericValue(digits[i])
            while (ans.peek().length == i) {
                val t: String = ans.remove()
                for (s in mapping[x].toCharArray()) {
                    ans.add(t + s)
                }
            }
        }
        return ans
    }
}

fun main() {
    println(LetterCombinationOfPhoneNumber().letterCombinations("23"))
}
