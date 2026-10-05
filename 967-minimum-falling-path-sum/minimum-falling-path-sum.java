class Solution {
    // int[][] dp;
    // public int Solve(int row, int col, int[][] matrix){
    //     if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return Integer.MAX_VALUE;

    //     if(row == 0) return matrix[row][col];

    //     if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

    //     int path1 = Solve(row - 1, col - 1, matrix);
    //     int path2 = Solve(row - 1, col, matrix);
    //     int path3 = Solve(row - 1, col + 1, matrix);

    //     return dp[row][col] = matrix[row][col] + Math.min(path1, Math.min(path2, path3)); 
    // }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[n][m];

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    dp[0][j] = matrix[0][j];
                }
                else{
                    int path1 = Integer.MAX_VALUE;
                    int path2 = Integer.MAX_VALUE;
                    int path3 = Integer.MAX_VALUE;

                    if(j > 0) path1 = dp[i - 1][j - 1];
                    path2 = dp[i - 1][j];
                    if(j < n - 1) path3 = dp[i - 1][j + 1];

                    dp[i][j] = matrix[i][j] + Math.min(path1, Math.min(path2, path3));
                }
            }
        }
        for(int i = 0; i < m; i++){
            result = Math.min(result, dp[m - 1][i]);
        }
        return result;
    }
}