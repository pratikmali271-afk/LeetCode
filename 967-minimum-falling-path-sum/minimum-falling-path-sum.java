class Solution {
    int[][] dp;
    public int Solve(int row, int col, int[][] matrix){
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) return Integer.MAX_VALUE;

        if(row == 0) return matrix[row][col];

        if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int path1 = Solve(row - 1, col - 1, matrix);
        int path2 = Solve(row - 1, col, matrix);
        int path3 = Solve(row - 1, col + 1, matrix);

        return dp[row][col] = matrix[row][col] + Math.min(path1, Math.min(path2, path3)); 
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        dp = new int[n][m];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            int ans = Solve(n - 1, i, matrix);
            result = Math.min(ans, result);
        }
        return result;
    }
}