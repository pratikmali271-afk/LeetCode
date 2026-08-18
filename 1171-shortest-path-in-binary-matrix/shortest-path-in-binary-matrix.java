class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        dist[0][0] = 1;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int i = curr.first;
            int j = curr.second;

            if (i == n - 1 && j == n - 1) {
                return dist[i][j];
            }

            for (int k = 0; k < 8; k++) {
                int ni = i + dr[k];
                int nj = j + dc[k];

                if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 0) {
                    if (dist[i][j] + 1 < dist[ni][nj]) {
                        dist[ni][nj] = dist[i][j] + 1;
                        q.offer(new Pair(ni, nj));
                    }
                }
            }
        }
        return -1;
    }
}