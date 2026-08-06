class Solution {

    public int[][] highestPeak(int[][] isWater) {

        int rows = isWater.length;
        int cols = isWater[0].length;

        int[][] height = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    height[i][j] = 0;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int k = 0; k < 4; k++) {

                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;

                    height[newRow][newCol] = height[row][col] + 1;

                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return height;
    }
}