class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        image[sr][sc] = color;
        q.offer(new Pair(sr, sc));
        vis[sr][sc] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;

            for(int i = 0; i < 4; i++){
                int newRow = r + dr[i];
                int newCol = c + dc[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && image[newRow][newCol] == initialColor){
                    vis[newRow][newCol] = true;
                    image[newRow][newCol] = color;
                    q.offer(new Pair(newRow, newCol));
                }
            }
        }
        return image;
    }
}