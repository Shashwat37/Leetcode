import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long tsp = 0;

            for (int i : piles) {
                tsp += (int) Math.ceil((double) i / mid);
                if (tsp > h) break;
            }

            if (tsp <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
