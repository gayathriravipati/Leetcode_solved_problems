class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int cc = image[sr][sc];
        if(cc!=color){
            dfs(image,sr,sc,cc,color);
        }
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int cc, int color){
        if(image[r][c] == cc){
            image[r][c] = color;
            if(r > 0){
                dfs(image,r-1,c,cc,color);
            }
            
            if(c > 0){
                dfs(image,r,c-1,cc,color);
            }
            
            if(r < image.length-1){
                dfs(image,r+1,c,cc,color);
            }
            
            if(c < image[0].length-1){
                dfs(image,r,c+1,cc,color);
            }
        }
    }
}