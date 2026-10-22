
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;
        int n = stones.length;

        int[] prev = new int[target + 1];

        // Base case: first stone
        for (int t = stones[0]; t <= target; t++) {
            prev[t] = stones[0];
        }

        for (int idx = 1; idx < n; idx++) {
            int[] temp = new int[target + 1];

            for (int t = 1; t <= target; t++) {
                int notTake = prev[t];

                int take = 0;
                if (stones[idx] <= t) {
                    take = stones[idx] + prev[t - stones[idx]];
                }
                temp[t] = Math.max(take, notTake);
            }
            prev = temp;
        }
        int subsetSum = prev[target];

        return sum - 2 * subsetSum;
    }
}
