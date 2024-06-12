class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }

    private void backtrack(List<String> combinations, StringBuilder current, int open, int close, int max) {
        // Base case: When we've used all pairs of parentheses, add to result
        if (current.length() == max * 2) {
            combinations.add(current.toString());
            return;
        }

        // If we can add an open parenthesis, do so and recurse
        if (open < max) {
            current.append("(");
            backtrack(combinations, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack: remove the added "("
        }
        
        // If we can add a close parenthesis, do so and recurse
        if (close < open) { 
            current.append(")");
            backtrack(combinations, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack: remove the added ")"
        }
    }
}