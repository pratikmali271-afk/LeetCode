class Solution {
    int[] dp;
    public int Solve(int[] nums, int idx) {

        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];

        int rob = nums[idx] + Solve(nums, idx + 2);
        int skip = Solve(nums, idx + 1);

        dp[idx] = Math.max(rob, skip);
        return dp[idx];
    }

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Solve(nums, 0);
    }
}