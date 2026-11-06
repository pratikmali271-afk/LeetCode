class Solution {
    int[][] dp;
    public int Solve(int i, String s, int j, String t){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = Solve(i - 1, s, j - 1, t) + Solve(i - 1, s, j, t);
        }
        return dp[i][j] = Solve(i - 1, s, j, t);
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        return Solve(m - 1, s, n - 1, t);
    }
}