import java.util.*;
class Solution {
    int daysNeeded(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                days++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int d) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int answer = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int neededDays = daysNeeded(weights, mid);
            if (neededDays <= d) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
