class Solution {
    int[][] dp;
    public int Solve(int[][] grid, int i, int j){
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        int up = Solve(grid, i - 1, j);
        int left = Solve(grid, i, j - 1);

        dp[i][j] = grid[i][j] + Math.min(up, left);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return Solve(grid, m - 1, n - 1);
    }
}