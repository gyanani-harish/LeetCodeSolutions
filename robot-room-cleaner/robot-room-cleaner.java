/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    // Directions: 0 - up, 1 - right, 2 - down, 3 - left
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // Set to keep track of visited cells
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    public void cleanRoom(Robot robot) {
        backtracking(robot, 0,0,0);
    }
    private void backtracking(Robot robot, int row, int col, int direction) {
        robot.clean();
        visited.add(new Pair<>(row, col));

        // Explore all four directions
        for (int i = 0; i < 4; i++) {
            int newDir = (direction + i) % 4;  // Try the next direction
            int newRow = row + directions[newDir][0];
            int newCol = col + directions[newDir][1];

            // Check if the cell is not visited and can be moved into
            if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) {
                backtracking(robot, newRow, newCol, newDir); 

                // Go back to the previous cell and original direction
                goBack(robot); 
            }
            robot.turnRight(); // Turn right to explore the next direction
        }
    }
    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}