class Solution {
    Boolean[][] dp;

    public boolean Solve(int index, int lastJump, int[] stones) {

        if(index == stones.length - 1) return true;

        if(dp[index][lastJump] != null) return dp[index][lastJump];

        for(int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if(jump <= 0) continue;
            int nextPosition = stones[index] + jump;

            // Find the stone having nextPosition
            for(int i = index + 1; i < stones.length; i++) {
                if(stones[i] == nextPosition) {
                    if(Solve(i, jump, stones)) {
                        return dp[index][lastJump] = true;
                    }
                    break;
                }
                if(stones[i] > nextPosition)
                    break;
            }
        }
        return dp[index][lastJump] = false;
    }

    public boolean canCross(int[] stones) {

        dp = new Boolean[stones.length][stones.length + 1];

        return Solve(0, 0, stones);
    }
}