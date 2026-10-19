class Solution {
    int[][] dp;
    public int Solve(int idx, int amount, int[] coins){
        if(amount == 0) return 1;
        if(idx < 0) return 0;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        
        int take1 = 0;
        int take2 = 0;
        if(coins[idx] <= amount){
            take1 = Solve(idx, amount - coins[idx], coins);
        }
        take2 = Solve(idx - 1, amount, coins);

        return dp[idx][amount] = take1 + take2; 
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return Solve(n - 1, amount, coins);
    }
}