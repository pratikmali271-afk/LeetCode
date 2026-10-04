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
        //int[][] dp = new int[n][n];
        int[] prev = new int[n];

        // for(int j = 0; j < triangle.get(n - 1).size(); j++){
        //     temp[j] = triangle.get(n - 1).get(j);
        // }

        for(int i = n - 1; i >= 0; i--){
            int[] temp = new int[n];
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i == n - 1){
                    temp[j] = triangle.get(n - 1).get(j);
                } else{
                    int left = prev[j];
                    int right = prev[j + 1];

                    temp[j] = triangle.get(i).get(j) + Math.min(left, right);
                }
            }
            prev = temp;
        }
        return prev[0];
    }
}