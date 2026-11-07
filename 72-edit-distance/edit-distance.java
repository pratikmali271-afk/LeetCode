class Solution {
    // int[][] dp;
    // public int Solve(int i, String s1, int j, String s2){
    //     if(i < 0) return j + 1;
    //     if(j < 0) return i + 1;
    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(s1.charAt(i) == s2.charAt(j)) return Solve(i - 1, s1, j - 1, s2);

    //     int insert = 1 +  Solve(i, s1, j - 1, s2);
    //     int delete = 1 +  Solve(i - 1, s1, j, s2);
    //     int replace = 1 +  Solve(i - 1, s1, j - 1, s2);

    //     return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    // }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j < m + 1; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else{
                    int insert = 1 +  dp[i][j - 1];
                    int delete = 1 +  dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] =  Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }
}