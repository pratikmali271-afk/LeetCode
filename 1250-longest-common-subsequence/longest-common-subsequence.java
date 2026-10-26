class Solution {
    int[][] dp;
    public int Solve(int idx1, String s1, int idx2, String s2){
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1) == s2.charAt(idx2)) return dp[idx1][idx2] = 1 + Solve(idx1 - 1, s1, idx2 - 1, s2);

        return dp[idx1][idx2] = Math.max(Solve(idx1 - 1, s1, idx2, s2), Solve(idx1, s1, idx2 - 1, s2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return Solve(text1.length() - 1, text1, text2.length() - 1, text2);
    }
}