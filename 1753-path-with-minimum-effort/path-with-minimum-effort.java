class tuple{
    int distance;
    int row;
    int col;

    tuple(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        pq.offer(new tuple(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!pq.isEmpty()){

            tuple curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int diff = curr.distance;

            if(row == n - 1 && col == m - 1) return diff;

            for(int k = 0; k < 4; k++){
                int nrow = row + dr[k];
                int ncol = col + dc[k];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.offer(new tuple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}