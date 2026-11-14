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

        // int[][][] dp = new int[n + 1][2][3];
        // dp[n][0][0] = dp[n][1][0] = 0;

        int[][] prev = new int[2][3];

        for(int idx = n; idx >= 0; idx--){
            int[][] temp = new int[2][3];
            for(int buy = 1; buy >= 0; buy--){
                for(int cap = 2; cap >= 1; cap--){
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
        return prev[1][2];
    }
}