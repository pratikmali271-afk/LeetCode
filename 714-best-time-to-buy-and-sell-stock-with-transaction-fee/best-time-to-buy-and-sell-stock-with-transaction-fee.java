class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // int[][] dp = new int[n + 1][2];
        // dp[n][0] = dp[n][1] = 0;
        int[] prev = new int[2];

        for(int idx = n; idx >= 0 ; idx--){
            int[] temp = new int[2];
            for(int buy = 1; buy >= 0; buy--){
                if(idx == n){
                    temp[buy] = 0;
                } else{
                    int profit = Integer.MIN_VALUE;
                    if(buy == 1){
                        profit = Math.max(-prices[idx] + prev[0] - fee, 0 + prev[1]);
                    } else{
                        profit = Math.max(prices[idx] + prev[1], 0 + prev[0]);
                    }
                    
                    temp[buy] = profit;
                }
            }
            prev = temp;
        }
        return prev[1];
    }
}