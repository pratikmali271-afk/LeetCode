
class Solution {
    int[][] dp;
    public int Solve(int idx, int target, int[] stones) {
        if (idx < 0 || target == 0) {
            return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = Solve(idx - 1, target, stones);

        int take = 0;
        if (stones[idx] <= target) {
            take = stones[idx] + Solve(idx - 1, target - stones[idx], stones);
        }

        return dp[idx][target] = Math.max(take, notTake);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;

        dp = new int[stones.length][target + 1];
        for(int i = 0; i < stones.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int subsetSum = Solve(stones.length - 1, target, stones);

        return sum - 2 * subsetSum;
    }
}
