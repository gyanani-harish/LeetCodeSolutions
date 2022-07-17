class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int i = 0;
        int j = 0;
        for (char[] row : grid) {
            j=0;
            for (int cell : row) {
                if (isFeasible(grid, i, j)) {
                    dfs(grid, i, j);
                    result++;
                }
                j++;
            }
            i++;
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        //boundary check
        if (isInsideBoundary(grid, i, j)) {
            return;
        }
        if (isAlreadyVisited(grid, i, j)) {
            return;
        }
        if (!isFeasible(grid, i, j)) {
            return;
        }
        grid[i][j] = '2';
        //top,right,down, left
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }

    private boolean isFeasible(char[][] grid, int i, int j) {
        return grid[i][j] == '1';
    }

    private boolean isAlreadyVisited(char[][] grid, int i, int j) {
        return grid[i][j] == '2';
    }

    private boolean isInsideBoundary(char[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}