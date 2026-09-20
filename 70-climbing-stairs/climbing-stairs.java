// Recursion
// class Solution {
//     public int climbStairs(int n) {
//         if(n == 0 || n == 1) return 1;
//         int left  =  climbStairs(n - 1);
//         int right =  climbStairs(n - 2);
//         return left + right;
//     }
// }

// // Menoization
// class Solution {
//     int[] dp;
//     public int climbStairs(int n) {
//         dp = new int[n + 1];
//         return solve(n);
//     }

//     public int solve(int n) {
//         if(n <= 1) return 1;
//         if(dp[n] != 0) return dp[n];

//         dp[n] = solve(n - 1) + solve(n - 2);

//         return dp[n];
//     }
// }

// tabulation
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         dp[0] = 1;
//         dp[1] = 1;

//         for(int i = 2; i <= n; i++){
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];
//     }
// }

class Solution {
    public int climbStairs(int n) {
       // int[] dp = new int[n + 1];
        int prev = 1;
        int prev2 = 1;

        for(int i = 2; i <= n; i++){
            int curr_i = prev + prev2;
            prev2 = prev;
            prev = curr_i;
        }

        return prev;
    }
}