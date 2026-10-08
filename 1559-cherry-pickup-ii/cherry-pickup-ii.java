class Solution {
    int[][][] dp;
    public int Solve(int row, int col1, int col2, int[][] grid) {
        int cols = grid[0].length;

        if(col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return Integer.MIN_VALUE;
        }
        if(row == grid.length - 1) {
            if(col1 == col2) {
                return grid[row][col1];
            } else {
                return grid[row][col1] + grid[row][col2];
            }
        }

        if(dp[row][col1][col2] != -1) return dp[row][col1][col2];

        int maxi = Integer.MIN_VALUE;
        for(int j = -1; j <= 1; j++) {
                int path1 = Solve(row + 1,col1 + j, col2 - 1, grid);
                int path2 = Solve(row + 1,col1 + j, col2, grid);
                int path3 = Solve(row + 1,col1 + j, col2 + 1, grid);

                int path = Math.max(path1, Math.max(path2, path3));

                int current;
                if(col1 == col2) {
                    current = grid[row][col1];
                } else {
                    current = grid[row][col1] + grid[row][col2];
                }
                maxi = Math.max(maxi, current + path);
        }
        return dp[row][col1][col2] = maxi;
    }

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        dp = new int[rows][cols][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Solve(0, 0, cols - 1, grid);
    }
}