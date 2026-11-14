class Solution {
    int[][][] dp;
    public int Solve(int idx, int buy, int cap, int[] prices){
        if(cap == 0) return 0;
        if(idx == prices.length) return 0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(-prices[idx] + Solve(idx + 1, 0, cap, prices), 0 + Solve(idx + 1, 1, cap, prices));
        } else{
            profit = Math.max(prices[idx] + Solve(idx + 1, 1, cap - 1, prices), Solve(idx + 1, 0, cap, prices));
        }

        return dp[idx][buy][cap] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Solve(0, 1, 2, prices);
    }
}