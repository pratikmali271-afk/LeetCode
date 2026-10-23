class Solution {
    // int[][] dp;
    // public int Solve(int idx, int amount, int[] coins){
    //     // if(amount == 0) return 1;
    //     if(idx == 0){
    //         if(amount%coins[idx] == 0) return amount/coins[idx];
    //         else return Integer.MAX_VALUE;
    //     }
    //     if(dp[idx][amount] != -1) return dp[idx][amount];

    //     int take = Integer.MAX_VALUE;
    //     if (coins[idx] <= amount) {
    //         int res = Solve(idx, amount - coins[idx], coins);
    //         if (res != Integer.MAX_VALUE) {
    //             take = 1 + res;
    //         }
    //     }
    //     int notTake =  Solve(idx - 1, amount, coins);

    //     return dp[idx][amount] = Math.min(take, notTake);
    // }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for(int j = 0; j < amount + 1; j++){
            if(j%coins[0] == 0) dp[0][j] = j/coins[0];
            else dp[0][j] = Integer.MAX_VALUE;
        }

        for(int idx = 1; idx < n; idx++){
            for(int j = 0; j < amount + 1; j++){
                int take = Integer.MAX_VALUE;
                if(coins[idx] <= j) {
                    int res = dp[idx][j - coins[idx]];
                    if(res != Integer.MAX_VALUE) take = 1 + res;
                }
                int notTake =  dp[idx - 1][j];

                dp[idx][j] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}