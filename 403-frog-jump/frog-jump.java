class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1] != 1) return false;
        Boolean[][] dp = new Boolean[n][n + 1];

        // First jump must be 1
        dp[1][1] = true;
        for(int i = 1; i < n; i++) {
            for(int lastJump = 1; lastJump <= n; lastJump++) {
                // Frog cannot reach this state
                if(dp[i][lastJump] == null || !dp[i][lastJump]) continue;

                // Try lastJump - 1, lastJump, lastJump + 1
                for(int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
                    if(jump <= 0) continue;

                    int nextPosition = stones[i] + jump;
                    for(int idx = i + 1; idx < n; idx++) {
                        if(stones[idx] == nextPosition) {
                            dp[idx][jump] = true;
                            break;
                        }

                        if(stones[idx] > nextPosition) break;
                    }
                }
            }
        }

        // Did we reach the last stone?
        for(int jump = 1; jump <= n; jump++) {
            if(dp[n - 1][jump] != null && dp[n - 1][jump]) {
                return true;
            }
        }
        return false;
    }
}