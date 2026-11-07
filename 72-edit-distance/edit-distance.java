class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // int[][] dp = new int[n + 1][m + 1];
        // for(int i = 0; i < n + 1; i++){
        //     dp[i][0] = i;
        // }
        // for(int j = 1; j < m + 1; j++){
        //     dp[0][j] = j;
        // }
        int[] prev = new int[m + 1];
        for(int i = 0; i < n + 1; i++){
            int[] temp = new int[m + 1];
            temp[0] = i;
            for(int j = 1; j < m + 1; j++){
                if(i == 0){
                    temp[j] = j;
                }
                else if(word1.charAt(i - 1) == word2.charAt(j - 1)) temp[j] = prev[j - 1];
                else{
                    int insert = 1 +  temp[j - 1];
                    int delete = 1 +  prev[j];
                    int replace = 1 + prev[j - 1];

                    temp[j] =  Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = temp;
        }
        return prev[m];
    }
}