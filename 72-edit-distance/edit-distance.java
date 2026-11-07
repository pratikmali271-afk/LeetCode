class Solution {
    int[][] dp;
    public int Solve(int i, String s1, int j, String s2){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return Solve(i - 1, s1, j - 1, s2);

        int insert = 1 +  Solve(i, s1, j - 1, s2);
        int delete = 1 +  Solve(i - 1, s1, j, s2);
        int replace = 1 +  Solve(i - 1, s1, j - 1, s2);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return Solve(n - 1, word1, m - 1, word2);
    }
}