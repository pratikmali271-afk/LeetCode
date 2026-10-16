
import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Store subset sums grouped by number of elements selected
        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate subset sums for both halves
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum1 = 0, sum2 = 0, count = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum1 += nums[i];
                    sum2 += nums[i + n];
                    count++;
                }
            }

            left[count].add(sum1);
            right[count].add(sum2);
        }

        // Sort right-half sums for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(right[i]);
        }

        int answer = Integer.MAX_VALUE;

        // Select k elements from left and n-k from right
        for (int k = 0; k <= n; k++) {
            for (int sum1 : left[k]) {
                int target = totalSum / 2 - sum1;

                List<Integer> candidates = right[n - k];

                int low = 0;
                int high = candidates.size() - 1;

                // Find the first right sum >= target
                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    if (candidates.get(mid) < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                // Check the closest candidate at or above target
                if (low < candidates.size()) {
                    int sum = sum1 + candidates.get(low);
                    answer = Math.min(answer,
                        Math.abs(totalSum - 2 * sum));
                }

                // Check the closest candidate below target
                if (low > 0) {
                    int sum = sum1 + candidates.get(low - 1);
                    answer = Math.min(answer,
                        Math.abs(totalSum - 2 * sum));
                }
            }
        }
        return answer;
    }
}
