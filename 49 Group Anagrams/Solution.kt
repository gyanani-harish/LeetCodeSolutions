class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
         return firstAlgoSortChars(strs)
    }

    /**
 * 0.5
1. convert string list to pair list and sort all chars in each string but keep the original order
["eat","tea","tan","ate","nat","bat"]
=>["aet","aet","ant","aet","ant","abt"]
2. sort the whole array
["eat","tea","tan","ate","nat","bat"]
=>["abt","aet","aet","aet","ant","ant"]
3. create arrays, start from 0, whenever match fails start new one
 */
    /**
 * Groups strings into lists of anagrams based on character sorting.
 * 
 * This function takes an array of strings and groups them into lists where
 * each list contains strings that are anagrams of each other. Anagrams are
 * determined by sorting the characters of each string alphabetically.
 *
 * @param strs An array of strings to be grouped.
 * @return A list of lists, where each inner list contains anagrams.
 */
fun firstAlgoSortChars(strs: Array<String>): List<List<String>> {
    // Create a list to hold string-sortedString pairs
    val pairList = mutableListOf<Pair<String, String>>() 

    // Add each string along with its sorted version as a pair to the list
    strs.forEach {
        pairList.add(Pair(sortString(it), it)) // (sortedString, originalString)
    }

    // Sort the list based on the sorted version of the strings (first element in pair)
    pairList.sortBy { it.first }

    // Create a list to store the grouped anagrams
    val resultList = mutableListOf<MutableList<String>>()
    var resultSubList = mutableListOf<String>()

    // Iterate through sorted pairs, grouping anagrams together
    pairList.forEachIndexed { index, pair ->
        if (index > 0 && pairList[index - 1].first != pair.first) { // New anagram group found
            resultList.add(resultSubList.toMutableList()) // Add previous group to result
            resultSubList = mutableListOf() // Start a new group
        }
        resultSubList.add(pair.second) // Add the original string to the current group
    }

    // Add the last group of anagrams to the result
    resultList.add(resultSubList.toMutableList())

    // Return the final list of anagram groups
    return resultList
}

/**
 * Sorts the characters of a string alphabetically.
 *
 * @param s The string to be sorted.
 * @return The sorted string.
 */
fun sortString(s: String): String {
    return s.toCharArray().sorted().joinToString("")
}
}
