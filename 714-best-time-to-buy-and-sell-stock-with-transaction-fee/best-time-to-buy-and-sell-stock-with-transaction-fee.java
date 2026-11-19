class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int idx = n - 1; idx >= 0 ; idx--){
            for(int buy = 1; buy >= 0; buy--){
                int profit = Integer.MIN_VALUE;
                if(buy == 1){
                    profit = Math.max(-prices[idx] + dp[idx + 1][0] - fee, 0 + dp[idx + 1][1]);
                } else{
                    profit = Math.max(prices[idx] + dp[idx + 1][1], 0 + dp[idx + 1][0]);
                }
                
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }
}