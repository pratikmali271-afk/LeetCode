class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        // First jump must be 1
        if(stones[1] != 1) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        Boolean[][] dp = new Boolean[n][n + 1];
        dp[1][1] = true;

        for(int i = 1; i < n; i++) {
            for(int lastJump = 1; lastJump <= n; lastJump++) {
                if(dp[i][lastJump] == null) continue;

                for(int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
                    if(jump <= 0) continue;

                    int nextPosition = stones[i] + jump;
                    if(map.containsKey(nextPosition)) {
                        int nextIndex = map.get(nextPosition);
                        dp[nextIndex][jump] = true;
                    }
                }
            }
        }

        for(int jump = 1; jump <= n; jump++) {
            if(dp[n - 1][jump] != null) return true;
        }
        return false;
    }
}