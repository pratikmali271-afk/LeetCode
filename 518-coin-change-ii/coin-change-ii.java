
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
       // int[][] dp = new int[n][amount + 1];
        int[] prev = new int[amount + 1];

        // for (int i = 0; i < n; i++) {
        //     dp[i][0] = 1;
        // }

        // for (int j = 0; j <= amount; j++) {
        //     if (j % coins[0] == 0) {
        //         dp[0][j] = 1;
        //     }
        // }

        for (int i = 0; i < n; i++) {
            int[] temp = new int[amount + 1];
            temp[0] = 1;
            for (int j = 0; j <= amount; j++) {
                if(i == 0){
                    if(j % coins[0] == 0) temp[j] = 1;
                } else{
                    int take = 0;
                    if (coins[i] <= j) {
                        take = temp[j - coins[i]];
                    }
                    int notTake = prev[j];
                    temp[j] = take + notTake;
                }
            }
            prev = temp;
        }
        return prev[amount];
    }
}
