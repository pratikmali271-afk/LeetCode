class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) return 0;

        int offset = sum;
        int[][] dp = new int[n + 1][2 * sum + 1];

        dp[0][offset] = 1;

        for (int i = 0; i < n; i++) {
            for (int s = -sum; s <= sum; s++) {
                if (dp[i][s + offset] == 0) continue;

                int ways = dp[i][s + offset];

                dp[i + 1][s + nums[i] + offset] += ways;
                dp[i + 1][s - nums[i] + offset] += ways;
            }
        }
        return dp[n][target + offset];
    }
}
