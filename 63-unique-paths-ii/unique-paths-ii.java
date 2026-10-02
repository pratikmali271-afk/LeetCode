class Solution {
    // int[][] dp;
    // public int Solve(int[][] obstacleGrid, int i, int j){
    //     if(i < 0 || j < 0) return 0;
    //     if(obstacleGrid[i][j] == 1) return 0;
    //     if(i == 0 && j == 0) return 1;
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int up = Solve(obstacleGrid, i - 1, j);
    //     int left = Solve(obstacleGrid, i, j - 1);

    //     dp[i][j] = up + left;
    //     return dp[i][j];
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) continue;
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                } else{
                    int up = 0;
                    int left = 0;

                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];

                    dp[i][j] = up + left; 
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}