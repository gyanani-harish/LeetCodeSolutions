class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean isVisited[][] = new boolean[rows][cols];
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    DFS(grid, i, j, isVisited);
                    result++;
                }
            }
        }
        return result;
    }

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void DFS(char[][] grid, int row, int col, boolean[][] isVisited) {
        isVisited[row][col] = true;

        // Recur for all the vertices adjacent to this
        // vertex
        List<Pair> list = new ArrayList<>();
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            list.add(new Pair(row - 1, col));
        }
        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            list.add(new Pair(row, col - 1));
        }
        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            list.add(new Pair(row + 1, col));
        }
        if (col + 1 < grid[row].length && grid[row][col + 1] == '1') {
            list.add(new Pair(row, col + 1));
        }
        Iterator<Pair> i = list.listIterator();
        while (i.hasNext()) {
            Pair n = i.next();
            if (!isVisited[n.row][n.col] && grid[n.row][n.col] == '1')
                DFS(grid, n.row, n.col, isVisited);
        }
    }
}