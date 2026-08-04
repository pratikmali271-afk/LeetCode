class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[rows][cols];
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int time = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            time = curr.time;

            for(int k = 0; k < 4; k++){
                int nRow = r + dr[k];
                int nCol = c + dc[k];

                if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1 && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    fresh--;
                    q.offer(new Pair(nRow, nCol, curr.time + 1));
                }
            }
        }
        return (fresh == 0) ? time : -1;
    }
}