class Solution {
    List<List<Integer>> dp;
    public int Solve(int idx, int row, List<List<Integer>> triangle){
        if(row >= triangle.size()) return 0;
        if(dp.get(row).get(idx) != Integer.MAX_VALUE) return dp.get(row).get(idx);

        int left = Solve(idx, row + 1, triangle);
        int right = Solve(idx + 1, row + 1, triangle);

        dp.get(row).set(idx, triangle.get(row).get(idx) + Math.min(left, right));

        return dp.get(row).get(idx);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new ArrayList<>();
        for (List<Integer> row : triangle) {
            List<Integer> newRow = new ArrayList<>();

            for (int i = 0; i < row.size(); i++) {
                newRow.add(Integer.MAX_VALUE);
            }

            dp.add(newRow);
        }
        return Solve(0, 0, triangle);
    }
}