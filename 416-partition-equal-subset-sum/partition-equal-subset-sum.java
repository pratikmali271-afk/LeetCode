class Solution {
    Boolean[][] dp;
    public boolean Solve(int idx, int target, int[] nums){
        if(target == 0) return true;
        if(idx == 0) return nums[0] == target;
        if(dp[idx][target] != null) return dp[idx][target];

        boolean notTake = Solve(idx - 1, target, nums);
        boolean Take = false;
        if(target >= nums[idx]){
            Take = Solve(idx - 1, target - nums[idx], nums);
        }
        return dp[idx][target] = notTake || Take;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 != 0) return false;

        dp = new Boolean[nums.length][sum/2 + 1];

        return Solve(nums.length - 1, sum/2, nums);
    }
}

// class Solution {
//     public boolean canPartition(int[] nums) {
        
//     }
// }