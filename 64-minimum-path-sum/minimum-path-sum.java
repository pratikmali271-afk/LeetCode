class Solution {
    // int[][] dp;
    // public int Solve(int[][] grid, int i, int j){
    //     if(i == 0 && j == 0) return grid[i][j];
    //     if(i < 0 || j < 0) return Integer.MAX_VALUE;
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int up = Solve(grid, i - 1, j);
    //     int left = Solve(grid, i, j - 1);

    //     dp[i][j] = grid[i][j] + Math.min(up, left);
    //     return dp[i][j];
    // }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                } else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];

                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}