// class Solution {
//     public int Solve(int[] nums, int idx){
//         if(idx >= nums.length) return 0;

//         int rob = nums[idx] + Solve(nums, idx + 2);
//         int skip = Solve(nums, idx + 1);

//         return Math.max(rob, skip);
//     }
//     public int rob(int[] nums) {
//         if(nums.length == 1) return nums[0];

//         int[] nums1 = new int[nums.length - 1];
//         int[] nums2 = new int[nums.length - 1];

//         for(int i = 0; i < nums.length - 1; i++){
//             nums1[i] = nums[i];
//         }
//         int idx = 0;
//         for(int i = 1; i < nums.length; i++){
//             nums2[idx] = nums[i];
//             idx++;
//         }

//         int ans1 = Solve(nums1, 0);
//         int ans2 = Solve(nums2, 0);

//         return Math.max(ans1, ans2);
//     }
// }

class Solution {
    int[] dp;
    public int Solve(int[] nums, int idx){
        if(idx >= nums.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int rob = nums[idx] + Solve(nums, idx + 2);
        int skip = Solve(nums, idx + 1);

        dp[idx] = Math.max(rob, skip);
        return dp[idx];
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        for(int i = 0; i < nums.length - 1; i++){
            nums1[i] = nums[i];
        }
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            nums2[idx] = nums[i];
            idx++;
        }

        dp = new int[nums.length - 1];

        Arrays.fill(dp, -1);
        int ans1 = Solve(nums1, 0);
        Arrays.fill(dp, -1);
        int ans2 = Solve(nums2, 0);

        return Math.max(ans1, ans2);
    }
}