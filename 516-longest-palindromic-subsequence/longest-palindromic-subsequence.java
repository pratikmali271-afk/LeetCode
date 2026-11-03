class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // int[][] dp = new int[m + 1][n + 1];
        int[] prev = new int[n + 1];
        // for(int i = 0; i < m + 1; i++){
        //     dp[i][0] = 0;
        // }
        // for(int i = 0; i < n + 1; i++){
        //     dp[0][i] = 0;
        // }

        for(int i = 0; i < m + 1; i++){
            int[] temp = new int[n + 1];
            for(int j = 0; j < n + 1; j++){
                if(i == 0 || j == 0){
                    temp[j] = 0;
                } else{
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)) temp[j] = 1 + prev[j - 1];
                    else temp[j] = Math.max(prev[j], temp[j - 1]);
                }
            }
            prev = temp;
        }
        return prev[n];
    }
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
         return longestCommonSubsequence(s, rev);
    }
}