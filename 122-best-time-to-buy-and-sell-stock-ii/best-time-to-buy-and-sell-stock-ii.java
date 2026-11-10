class Solution {
    int[][] dp;
    public int Solve(int idx, int buy, int[] prices){
        if(idx == prices.length) return 0;
        if(dp[idx][buy] != -1) return  dp[idx][buy];
        
        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(-prices[idx] + Solve(idx + 1, 0, prices), 0 + Solve(idx + 1, 1, prices));
        } else{
            profit = Math.max(prices[idx] + Solve(idx + 1, 1, prices), 0 + Solve(idx + 1, 0, prices));
        }
        
        return  dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2];
        for(int i = 0; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }
        return Solve(0, 1, prices);
    }
}

// class Solution {
//     // int[][] dp;
//     // public int Solve(int idx, int buy, int[] prices){
//     //     if(idx == prices.length) return 0;
//     //     if(dp[idx][buy] != -1) return  dp[idx][buy];
        
//     //     int profit = Integer.MIN_VALUE;
//     //     if(buy == 1){
//     //         profit = Math.max(-prices[idx] + Solve(idx + 1, 0, prices), 0 + Solve(idx + 1, 1, prices));
//     //     } else{
//     //         profit = Math.max(prices[idx] + Solve(idx + 1, 1, prices), 0 + Solve(idx + 1, 0, prices));
//     //     }
        
//     //     return  dp[idx][buy] = profit;
//     // }
//     public int maxProfit(int[] prices) {
//         int n = prices.length;

//         int[][] dp = new int[n + 1][2];
//         dp[n][0] = dp[n][1] = 0;

//         for(int idx = n - 1; idx >= 0 ; idx--){
//             for(int buy = 1; buy >= 0; buy--){
//                 int profit = Integer.MIN_VALUE;
//                 if(buy == 1){
//                     profit = Math.max(-prices[idx] + dp[idx + 1][0], 0 + dp[idx + 1][1]);
//                 } else{
//                     profit = Math.max(prices[idx] + dp[idx + 1][1], 0 + dp[idx + 1][0]);
//                 }
                
//                 dp[idx][buy] = profit;
//             }
//         }
//         return dp[0][1];
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;

//         // int[][] dp = new int[n + 1][2];
//         // dp[n][0] = dp[n][1] = 0;
//         int[] prev = new int[2];

//         for(int idx = n; idx >= 0 ; idx--){
//             int[] temp = new int[2];
//             for(int buy = 1; buy >= 0; buy--){
//                 if(idx == n){
//                     temp[buy] = 0;
//                 } else{
//                     int profit = Integer.MIN_VALUE;
//                     if(buy == 1){
//                         profit = Math.max(-prices[idx] + prev[0], 0 + prev[1]);
//                     } else{
//                         profit = Math.max(prices[idx] + prev[1], 0 + prev[0]);
//                     }
                    
//                     temp[buy] = profit;
//                 }
//             }
//             prev = temp;
//         }
//         return prev[1];
//     }
// }