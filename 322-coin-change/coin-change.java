class Solution {
    int[][] dp;
    public int Solve(int idx, int amount, int[] coins){
        // if(amount == 0) return 1;
        if(idx == 0){
            if(amount%coins[idx] == 0) return amount/coins[idx];
            else return Integer.MAX_VALUE;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int take = Integer.MAX_VALUE;
        if (coins[idx] <= amount) {
            int res = Solve(idx, amount - coins[idx], coins);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        int notTake =  Solve(idx - 1, amount, coins);

        return dp[idx][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int ans = Solve(n - 1, amount, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}