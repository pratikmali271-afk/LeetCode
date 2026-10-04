class Solution {
    // int[][] dp;
    // public int Solve(int idx, int row, List<List<Integer>> triangle){
    //     if(row >= triangle.size()) return 0;
    //     if(dp[row][idx] != Integer.MAX_VALUE) return dp[row][idx];

    //     int left = Solve(idx, row + 1, triangle);
    //     int right = Solve(idx + 1, row + 1, triangle);

    //     dp[row][idx] = triangle.get(row).get(idx) + Math.min(left, right);

    //     return dp[row][idx];
    // }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int j = 0; j < triangle.get(n - 1).size(); j++){
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int left = dp[i + 1][j];
                int right = dp[i + 1][j + 1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
            }
        }
        return dp[0][0];
    }
}