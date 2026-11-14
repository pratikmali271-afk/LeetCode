class Solution {
    // int[][][] dp;
    // public int Solve(int idx, int buy, int cap, int[] prices){
    //     if(cap == 0) return 0;
    //     if(idx == prices.length) return 0;
    //     if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

    //     int profit = Integer.MIN_VALUE;
    //     if(buy == 1){
    //         profit = Math.max(-prices[idx] + Solve(idx + 1, 0, cap, prices), 0 + Solve(idx + 1, 1, cap, prices));
    //     } else{
    //         profit = Math.max(prices[idx] + Solve(idx + 1, 1, cap - 1, prices), Solve(idx + 1, 0, cap, prices));
    //     }

    //     return dp[idx][buy][cap] = profit;
    // }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];
        dp[n][0][0] = dp[n][1][0] = 0;

        for(int idx = n - 1; idx >= 0; idx--){
            for(int buy = 1; buy >= 0; buy--){
                for(int cap = 2; cap >= 1; cap--){
                    int profit = Integer.MIN_VALUE;
                    if(buy == 1){
                        profit = Math.max(-prices[idx] + dp[idx + 1][0][cap], 0 + dp[idx + 1][1][cap]);
                    } else{
                        profit = Math.max(prices[idx] + dp[idx + 1][1][cap - 1], dp[idx + 1][0][cap]);
                    }

                    dp[idx][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];
    }
}