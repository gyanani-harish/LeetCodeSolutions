import java.util.AbstractMap;
class Solution {
    /**
    [1,0,0,1]
    [0,1,1,0]
    [0,1,1,1]
    [1,0,1,1]
    
    [1,1,0],
    [1,1,0],
    [0,0,1]
    
    [
    [1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],
    [0,1,0,1,0,0,0,0,0,0,0,0,0,1,0],
    [0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],
    [0,1,0,1,0,0,0,1,0,0,0,1,0,0,0],
    [0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],
    [0,0,0,0,0,1,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],
    [0,0,0,1,0,0,0,1,1,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,1,1,0,0,0,0,0,0],
    [1,0,0,0,0,0,0,0,0,1,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0,1,0,0,0,0],
    [0,0,0,1,0,0,0,0,0,0,0,1,0,0,0],
    [0,0,0,0,1,0,0,0,0,0,0,0,1,0,0],
    [0,1,0,0,0,0,0,0,0,0,0,0,0,1,0],
    [0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
    ]
    */
    public int findCircleNum(int[][] isConnected) {
        return dfs(isConnected);
    }
        private int dfs(int[][] mat) {
            int count = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 1) {
                        count++;
                        //System.out.println("\n" + "new start i=" + i + " j=" + j);
                        dfs(mat, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] mat, int i, int j) {
            //System.out.println("dfs i=" + i + " j=" + j);
            if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[i].length - 1 || mat[i][j] == 0 || mat[i][j] == 2) {
                return;
            }

            mat[i][j] = 2;
            //System.out.println("marked i=" + i + " j=" + j);
            for(j=0;j<mat.length;j++){
                dfs(mat, i, j);
                dfs(mat, j, i);
            }
        }
}