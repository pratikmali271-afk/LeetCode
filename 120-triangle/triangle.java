class Solution {
    int[][] dp;
    public int Solve(int idx, int row, List<List<Integer>> triangle){
        if(row >= triangle.size()) return 0;
        if(dp[row][idx] != Integer.MAX_VALUE) return dp[row][idx];

        int left = Solve(idx, row + 1, triangle);
        int right = Solve(idx + 1, row + 1, triangle);

        dp[row][idx] = triangle.get(row).get(idx) + Math.min(left, right);

        return dp[row][idx];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return Solve(0, 0, triangle);
    }
}