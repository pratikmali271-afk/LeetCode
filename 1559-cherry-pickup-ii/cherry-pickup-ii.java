class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];
        for(int j1 = 0; j1 < cols; j1++){
            for(int j2 = 0; j2 < cols; j2++){
                if(j1 == j2) dp[rows - 1][j1][j2] = grid[rows - 1][j1];
                else dp[rows - 1][j1][j2] = grid[rows - 1][j1] + grid[rows - 1][j2];
            }
        }

        for(int i = rows - 2; i >= 0; i--){
            for(int j1 = 0; j1 < cols; j1++){
                for(int j2 = 0; j2 < cols; j2++){

                    int maxi = Integer.MIN_VALUE;

                    for(int d1 = -1; d1 <= 1; d1++){
                        for(int d2 = -1; d2 <= 1; d2++){

                            int newJ1 = j1 + d1;
                            int newJ2 = j2 + d2;

                            if(newJ1 < 0 || newJ1 >= cols || newJ2 < 0 || newJ2 >= cols) {
                                continue;
                            }

                            int path = dp[i + 1][newJ1][newJ2];
                            int current;

                            if(j1 == j2) current = grid[i][j1];
                            else current = grid[i][j1] + grid[i][j2];

                            maxi = Math.max(maxi, current + path);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][cols - 1];
    }
}