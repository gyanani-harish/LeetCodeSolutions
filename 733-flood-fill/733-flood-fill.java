class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image, sr, sc, image[sr][sc], color);
    }
     private int[][] dfs(int[][] img, int x, int y, int current, int color){
        if(x<0 || y<0 || x>=img.length || y>=img[0].length){
            return img;
        }
        if(img[x][y] == color){
            return img;
        }

        if(current == img[x][y]){
            img[x][y] = color;
        } else {
            return img;
        }
        dfs(img, x+1, y, current, color);//right
        dfs(img, x, y+1, current, color);//down
        dfs(img, x-1, y, current, color);//left
        dfs(img, x, y-1, current, color);//top
        return img;
    }
}