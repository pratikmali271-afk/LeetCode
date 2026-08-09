// class Pair{
//     int first;
//     int second;
//     Pair(int first, int second){
//         this.first = first;
//         this.second = second;
//     }
// }
// class Solution {
//     public int numEnclaves(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;

//         Queue<Pair> q = new LinkedList<>();
//         boolean[][] vis = new boolean[rows][cols];
 
//         for(int i = 0; i < rows; i++){
//             if(grid[i][0] == 1){
//                 q.offer(new Pair(i, 0));
//                 vis[i][0] = true;
//             }
//             if(grid[i][cols - 1] == 1){
//                 q.offer(new Pair(i, cols -1));
//                 vis[i][cols - 1] = true;
//             }
//         }
//         for(int j = 0; j < cols; j++){
//             if(grid[0][j] == 1){
//                 q.offer(new Pair(0, j));
//                 vis[0][j] = true;
//             }
//             if(grid[rows - 1][j] == 1){
//                 q.offer(new Pair(rows - 1, j));
//                 vis[rows - 1][j] = true;
//             }
//         }

//         int[] dr = {-1, 1, 0, 0};
//         int[] dc = {0, 0, -1, 1};

//         while(!q.isEmpty()){

//             Pair curr = q.poll();
//             int r = curr.first;
//             int c = curr.second;

//             for(int k = 0; k < 4; k++){
//                 int newRow = r + dr[k];
//                 int newCol = c + dc[k];

//                 if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !vis[newRow][newCol] && grid[newRow][newCol] == 1){
//                     q.offer(new Pair(newRow, newCol));
//                     vis[newRow][newCol] = true;
//                 }
//             }
//         }

//         int count = 0;
//         for(int i = 0; i < rows; i++){
//             for(int j = 0; j < cols; j++){
//                 if(grid[i][j] == 1 && !vis[i][j]){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

// Using DFS
class Solution {
    public void dfs(int row, int col, int[][] grid, boolean[][] vis){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;

        if(grid[row][col] != 1) return;
        if(vis[row][col]) return;

        vis[row][col] = true;

        dfs(row + 1, col, grid, vis);
        dfs(row - 1, col, grid, vis);
        dfs(row, col - 1, grid, vis);
        dfs(row, col + 1, grid, vis);

    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1) dfs(i, 0, grid, vis);
            if(grid[i][m - 1] == 1) dfs(i, m - 1, grid, vis);
        }

        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1) dfs(0, j, grid, vis);
            if(grid[n - 1][j] == 1) dfs(n - 1, j, grid, vis);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]) count++;
            }
        }

        return count;
    }
}