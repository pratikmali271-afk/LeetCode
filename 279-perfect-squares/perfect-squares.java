class Solution {
    // int[][] dp;
    // public int Solve(int idx, int target, int[] sq){
    //     if(idx == 0) return target;
    //     if(dp[idx][target] != -1) return dp[idx][target];

    //     int take = Integer.MAX_VALUE;
    //     if(sq[idx] <= target){
    //         take = 1 + Solve(idx, target - sq[idx], sq);
    //     }

    //     int notTake = Solve(idx - 1, target, sq);

    //     return dp[idx][target] = Math.min(take, notTake);
    // }
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1;  i * i <= n; i++){
            list.add(i*i);
        }

        int[] sq = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            sq[i] = list.get(i);
        }

        int[][] dp = new int[sq.length][n + 1];
        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }

        for(int idx = 1; idx < sq.length; idx++){
            for(int target = 0; target <= n; target++){
                int take = Integer.MAX_VALUE;
                if(sq[idx] <= target){
                    take = 1 + dp[idx][target - sq[idx]];
                }

                int notTake = dp[idx - 1][target];

                dp[idx][target] = Math.min(take, notTake);
            }
        }

        return dp[sq.length - 1][n];
    }
}