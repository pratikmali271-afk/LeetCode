class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
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

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol]){
                    dist[newRow][newCol] = dist[r][c] + 1;
                    vis[newRow][newCol] = true;
                    q.offer(new Pair(newRow, newCol));
                }
            }
        }
        return dist;
    }
}