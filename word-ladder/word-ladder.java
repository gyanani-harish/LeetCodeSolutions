class Solution {
    /**
    Sequence

Initialization:

Convert the wordList into a HashSet called wordSet to enable efficient membership checks (O(1) lookup time).
Check if the endWord exists in the wordSet. If not, there is no possible transformation, and the algorithm returns 0.
Create a queue queue to store words along with their transformation level.
Start the BFS by adding the beginWord to the queue at level 1.
Create a set visited to keep track of visited words. Add the beginWord as the first visited word.
BFS Traversal:

While the queue is not empty:
Initialize a variable size to keep track of the number of words at the current level.
Loop through the current level's words (from 0 to size - 1):
Dequeue the word currentWord from the front of the queue.
If currentWord is the endWord, return the current level as this is the shortest path.
Explore all possible word transformations of currentWord by replacing one character at a time with all lowercase letters 'a' to 'z'.
For each generated newWord:
If newWord is in the wordSet and has not been visited before:
Add newWord to the queue with an incremented level (level + 1).
Mark newWord as visited to prevent cycles.
Increment the level by 1 to move to the next level of transformation.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a set for efficient word lookups
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) { // Optimization: endWord must be in the wordList
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;  // Start at level 1 (beginWord is level 1)

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Found the endWord, return the level (shortest transformation length)
                if (currentWord.equals(endWord)) { 
                    return level;
                }

                // Explore all one-character transformations of the current word
                char[] chars = currentWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c; // Replace one character
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[j] = originalChar; // Reset to the original character
                }
            }
            level++; // Move to the next level
        }

        return 0; // No transformation sequence found
    }

}