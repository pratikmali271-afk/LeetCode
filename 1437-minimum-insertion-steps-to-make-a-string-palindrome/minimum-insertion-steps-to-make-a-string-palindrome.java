class Solution {
    int[][] dp;
    public int Solve(int idx1, String text1, int idx2, String text2){
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(text1.charAt(idx1) == text2.charAt(idx2)) return 1 + Solve(idx1 - 1, text1, idx2 - 1, text2);

        return dp[idx1][idx2] = Math.max(Solve(idx1 - 1, text1, idx2, text2), Solve(idx1, text1, idx2 - 1, text2));
    }
    public int longestCommonSubsequence(String text1, String text2){
        dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return Solve(text1.length() - 1, text1, text2.length() - 1, text2);
    }
    public int longestPalindromeSubseq(String s){
        String rev = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, rev);
    }
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}