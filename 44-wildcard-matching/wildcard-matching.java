class Solution {
    // Boolean[][] dp;
    // public boolean Solve(int i, String s, int j, String p) {

    //     // Both strings are completely matched
    //     if(i < 0 && j < 0) return true;

    //     // Pattern is exhausted, but s still has characters
    //     if(j < 0) return false;

    //     // String is exhausted: remaining pattern must contain only *
    //     if(i < 0) {
    //         for(int k = 0; k <= j; k++) {
    //             if(p.charAt(k) != '*') return false;
    //         }
    //         return true;
    //     }

    //     if(dp[i][j] != null) return dp[i][j];

    //     if(p.charAt(j) == '*') {
    //         return dp[i][j] = Solve(i, s, j - 1, p) || Solve(i - 1, s, j, p);
    //     }
    //     if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
    //         return dp[i][j] = Solve(i - 1, s, j - 1, p);
    //     }
    //     return dp[i][j] = false;
    // }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n + 1][m + 1];

        dp[0][0] = true;
        for(int i = 1; i < n + 1; i++){
            dp[i][0] = false;
        }
        for(int j = 1; j < m + 1; j++){
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                else if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
