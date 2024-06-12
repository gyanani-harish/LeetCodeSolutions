class Solution {
    // Map digits to letters
    private static final Map<Character, String> digitLetters = new HashMap<>();
    static {
        digitLetters.put('2', "abc");
        digitLetters.put('3', "def");
        digitLetters.put('4', "ghi");
        digitLetters.put('5', "jkl");
        digitLetters.put('6', "mno");
        digitLetters.put('7', "pqrs");
        digitLetters.put('8', "tuv");
        digitLetters.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations; // Base case: empty input
        }
        backtrack(combinations, digits, 0, new StringBuilder()); // Start backtracking
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, int index, StringBuilder current) {
        // Base case: if the current combination is the same length as digits, it's complete
        if (current.length() == digits.length()) { 
            combinations.add(current.toString());
            return;
        }

        // Get letters for the current digit
        String letters = digitLetters.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));          // Add the letter
            backtrack(combinations, digits, index + 1, current); // Recurse for the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack: remove the added letter
        }
    }
}