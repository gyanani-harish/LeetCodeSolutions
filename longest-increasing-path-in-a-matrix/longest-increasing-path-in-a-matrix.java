class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
    int[][] cache = new int[m][n]; // Memoization table
    int maxPath = 0;

    // DFS with memoization
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            maxPath = Math.max(maxPath, dfs(matrix, i, j, cache));
        }
    }
    return maxPath;
}

private int dfs(int[][] matrix, int i, int j, int[][] cache) {
    if (cache[i][j] != 0) return cache[i][j]; // Use cached result if available

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Directions
    int max = 1; // Minimum path length is 1 (current cell)

    for (int[] dir : dirs) {
        int x = i + dir[0], y = j + dir[1];
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) 
            continue; // Skip out of bounds or decreasing values
        
        int len = 1 + dfs(matrix, x, y, cache); 
        max = Math.max(max, len);
    }

    cache[i][j] = max; // Store result in the memoization table
    return max;
}
}