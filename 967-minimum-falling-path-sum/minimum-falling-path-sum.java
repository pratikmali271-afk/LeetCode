class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[n];
        for(int j = 0; j < n; j++){
            prev[j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++){
            int[] temp = new int[n];
            for(int j = 0; j < n; j++){
                int left = Integer.MAX_VALUE;
                int middle = prev[j];
                int right = Integer.MAX_VALUE;

                if(j > 0) left = prev[j - 1];
                if(j < n - 1) right = prev[j + 1];

                temp[j] = matrix[i][j] + Math.min(left, Math.min(middle, right));
            }
            prev = temp;
        }

        int result = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            result = Math.min(result, prev[j]);
        }
        return result;
    }
}