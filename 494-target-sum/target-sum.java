class Solution {
    int[][] dp;
    int offset;
    public int Solve(int idx, int target, int[] nums){
        if (target < -offset || target > offset) return 0;

        if(idx < 0 && target == 0) return 1;
        if(idx < 0 && target != 0) return 0;

        int col = target + offset;
        if(dp[idx][col] != -1) return dp[idx][col];

        int plus = Solve(idx - 1, target - nums[idx], nums);
        int minus = Solve(idx - 1, target + nums[idx], nums);

        return dp[idx][col] = plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if (Math.abs(target) > sum) return 0;

        offset = sum;
        dp = new int[n][2 * sum + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return Solve(n - 1, target, nums);
    }
}