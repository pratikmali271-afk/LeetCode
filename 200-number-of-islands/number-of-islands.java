class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int row, int col, char[][] grid, boolean[][] vis){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row, col));
        vis[row][col] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;

            for(int k = 0; k < 4; k++){
                int newRow = r + dr[k];
                int newCol = c + dc[k];

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1' && !vis[newRow][newCol]){
                    vis[newRow][newCol] = true;
                    q.offer(new Pair(newRow, newCol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int count = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }
}