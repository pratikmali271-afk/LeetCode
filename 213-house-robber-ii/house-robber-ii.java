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
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

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

        int prev2 = nums1[0];
        int prev = Math.max(nums1[0], nums1[1]);
        for(int i = 2; i < nums1.length; i++){
            int rob = nums1[i] + prev2;
            int skip = prev;
            int result = Math.max(rob, skip);

            prev2 = prev;
            prev = result; 
        }
        int ans1 = prev;

        // Arrays.fill(dp, 0);

        prev2 = nums2[0];
        prev = Math.max(nums2[0], nums2[1]);
        for(int i = 2; i < nums2.length; i++){
            int rob = nums2[i] + prev2;
            int skip = prev;
            int result = Math.max(rob, skip);

            prev2 = prev;
            prev = result; 
        }
        int ans2 = prev;

        return Math.max(ans1, ans2);
    }
}