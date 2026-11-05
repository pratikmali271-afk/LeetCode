
class Solution {
    int[][] dp;
    public void longestCommonSubsequence(String S1, String S2) {
        int m = S1.length();
        int n = S2.length();

        dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
    public String printingLCS(String S1, String S2) {
        int i = S1.length();
        int j = S2.length();

        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                ans.append(S1.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(S1.charAt(i - 1));
                i--;
            }
            else {
                ans.append(S2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            ans.append(S1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(S2.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        longestCommonSubsequence(str1, str2);
        return printingLCS(str1, str2);
    }
}
