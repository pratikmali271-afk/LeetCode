class Solution {
    public int Solve(int idx, int prev_idx, int[] nums, int[][] dp) {
        if (idx == nums.length) return 0;

        if (dp[idx][prev_idx + 1] != -1) return dp[idx][prev_idx + 1];

        int take = 0;
        if (prev_idx == -1 || nums[idx] > nums[prev_idx]) take = 1 + Solve(idx + 1, idx, nums, dp);

        int not_take = Solve(idx + 1, prev_idx, nums, dp);

        return dp[idx][prev_idx + 1] = Math.max(take, not_take);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return Solve(0, -1, nums, dp);
    }
}