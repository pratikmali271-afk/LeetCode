class Solution {
    Boolean[][] dp;
    public boolean Solve(int i, String s, int j, String p) {

        // Both strings are completely matched
        if(i < 0 && j < 0) return true;

        // Pattern is exhausted, but s still has characters
        if(j < 0) return false;

        // String is exhausted: remaining pattern must contain only *
        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(p.charAt(j) == '*') {
            return dp[i][j] = Solve(i, s, j - 1, p) || Solve(i - 1, s, j, p);
        }
        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            return dp[i][j] = Solve(i - 1, s, j - 1, p);
        }
        return dp[i][j] = false;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        dp = new Boolean[n][m];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], false);
        // } 

        return Solve(n - 1, s, m - 1, p);
    }
}
