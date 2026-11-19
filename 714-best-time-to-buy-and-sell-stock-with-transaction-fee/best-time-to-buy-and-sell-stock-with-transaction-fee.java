class Solution {
    int[][] dp;
    public int Solve(int idx, int buy, int[] prices, int fee){
        if(idx == prices.length) return 0;
        if(dp[idx][buy] != -1) return  dp[idx][buy];
        
        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(-prices[idx] + Solve(idx + 1, 0, prices, fee) - fee, 0 + Solve(idx + 1, 1, prices, fee));
        } else{
            profit = Math.max(prices[idx] + Solve(idx + 1, 1, prices, fee), 0 + Solve(idx + 1, 0, prices, fee));
        }
        
        return  dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        dp = new int[n][2];
        for(int i = 0; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }
        return Solve(0, 1, prices, fee);
    }
}