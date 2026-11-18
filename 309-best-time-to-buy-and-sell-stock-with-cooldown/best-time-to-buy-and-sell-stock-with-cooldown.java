class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prev = new int[2];
        int[] prev2 = new int[2];

        for(int idx = n - 1; idx >= 0; idx--){
            int[] temp = new int[2];
            for(int buy = 1; buy >= 0; buy--){
                if(buy == 1){
                    temp[buy] = Math.max(
                        -prices[idx] + prev[0],
                        prev[1]
                    );
                } else {
                    temp[buy] = Math.max(
                        prices[idx] + prev2[1],
                        prev[0]
                    );
                }
            }
            prev2 = prev;
            prev = temp;
        }
        return prev[1];
    }
}