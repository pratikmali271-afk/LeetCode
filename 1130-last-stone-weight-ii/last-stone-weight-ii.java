
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        int n = stones.length;

        int[][] dp = new int[n][target + 1];

        // First row: only the first stone is available
        for (int t = stones[0]; t <= target; t++) {
            dp[0][t] = stones[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int t = 1; t <= target; t++) {

                int notTake = dp[idx - 1][t];

                int take = 0;
                if (stones[idx] <= t) {
                    take = stones[idx] + dp[idx - 1][t - stones[idx]];
                }
                dp[idx][t] = Math.max(take, notTake);
            }
        }
        int subsetSum = dp[n - 1][target];

        return sum - 2 * subsetSum;
    }
}
