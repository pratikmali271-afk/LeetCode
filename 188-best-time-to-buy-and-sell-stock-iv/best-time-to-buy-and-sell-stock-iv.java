class Solution {
    int[][][] dp;
    public int Solve(int idx, int buy, int k, int[] prices){
        if(k == 0) return 0;
        if(idx == prices.length) return 0;
        if(dp[idx][buy][k] != -1) return dp[idx][buy][k];

        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(-prices[idx] + Solve(idx + 1, 0, k, prices), 0 + Solve(idx + 1, 1, k, prices));
        } else{
            profit = Math.max(prices[idx] + Solve(idx + 1, 1, k - 1, prices), Solve(idx + 1, 0, k, prices));
        }

        return dp[idx][buy][k] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        dp = new int[n][2][k + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Solve(0, 1, k, prices);
    }
}