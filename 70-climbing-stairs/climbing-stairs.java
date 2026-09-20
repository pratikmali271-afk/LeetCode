// class Solution {
//     public int climbStairs(int n) {
//         if(n == 0 || n == 1) return 1;
//         int left  =  climbStairs(n - 1);
//         int right =  climbStairs(n - 2);
//         return left + right;
//     }
// }

class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return solve(n);
    }

    public int solve(int n) {
        if(n <= 1) return 1;
        if(dp[n] != 0) return dp[n];

        dp[n] = solve(n - 1) + solve(n - 2);

        return dp[n];
    }
}