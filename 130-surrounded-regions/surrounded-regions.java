class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O'){
                q.offer(new Pair(i, 0));
                vis[i][0] = true;
            }
            if(board[i][m - 1] == 'O'){
                q.offer(new Pair(i, m - 1));
                vis[i][m - 1] = true;
            }
        }
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O'){
                q.offer(new Pair(0, j));
                vis[0][j] = true;
            }
            if(board[n - 1][j] == 'O'){
                q.offer(new Pair(n - 1, j));
                vis[n - 1][j] = true;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            int r = curr.first;
            int c = curr.second;

            for(int i = 0; i < 4; i++){
                int newRow = r + dr[i];
                int newCol = c + dc[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && board[newRow][newCol] == 'O'){
                    q.offer(new Pair(newRow, newCol));
                    vis[newRow][newCol] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}