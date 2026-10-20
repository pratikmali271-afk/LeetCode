class Solution {
    static final int MOD = 1_000_000_007;
    int[][] dp;
    public int Solve(int idx, int sum, int[] values, int[] freq, int l, int r){
        if (sum > r) return 0;
        if(idx == values.length){
            if(sum >= l && sum <= r) return 1;
            return 0;
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int count = 0;

        for(int k = 0; k <= freq[idx]; k++){
            count = (count + Solve(idx + 1, sum + k*values[idx], values, freq, l, r))% MOD;
        }
        return dp[idx][sum] = (int)count;
    }
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int[] freq = new int[20001];

        for (int num : nums) {
            freq[num]++;
        }

        List<Integer> valuesList = new ArrayList<>();

        for (int i = 0; i <= 20000; i++) {
            if (freq[i] > 0) {
                valuesList.add(i);
            }
        }

        int[] values = new int[valuesList.size()];
        int[] frequencies = new int[valuesList.size()];

        for (int i = 0; i < valuesList.size(); i++) {
            values[i] = valuesList.get(i);
            frequencies[i] = freq[values[i]];
        }

        dp = new int[values.length][r + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return Solve(0, 0, values, frequencies, l, r);
    }
}