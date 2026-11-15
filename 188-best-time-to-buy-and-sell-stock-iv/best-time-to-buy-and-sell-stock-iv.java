class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // int[][][] dp = new int[n + 1][2][3];
        // dp[n][0][0] = dp[n][1][0] = 0;

        int[][] prev = new int[2][k + 1];

        for(int idx = n; idx >= 0; idx--){
            int[][] temp = new int[2][k + 1];
            for(int buy = 1; buy >= 0; buy--){
                for(int cap = k; cap >= 1; cap--){
                    if(idx == n){
                        temp[buy][0] = 0;
                    } else{
                        int profit = Integer.MIN_VALUE;
                        if(buy == 1){
                            profit = Math.max(-prices[idx] + prev[0][cap], 0 + prev[1][cap]);
                        } else{
                            profit = Math.max(prices[idx] + prev[1][cap - 1], prev[0][cap]);
                        }

                        temp[buy][cap] = profit;
                    }
                }
            }
            prev = temp;
        }
        return prev[1][k];
    }
}