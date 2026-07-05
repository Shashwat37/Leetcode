import java.util.*;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = 0;

            for (int num : nums) {
                sum += (int) Math.ceil((double) num / mid);
            }

            if (sum <= threshold) {
                ans = mid;        // possible answer
                high = mid - 1;   // try smaller divisor
            } else {
                low = mid + 1;    // divisor too small
            }
        }

        return ans;
    }
}
