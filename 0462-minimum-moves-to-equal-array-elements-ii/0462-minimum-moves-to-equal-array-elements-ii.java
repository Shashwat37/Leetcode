import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums[nums.length / 2];
        int ans = 0;

        for (int x : nums) {
            ans += Math.abs(x - mid);
        }

        return ans;
    }
}