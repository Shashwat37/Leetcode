import java.util.*;

class Solution {
    int[] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int ans = -1;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                cnt++;

                if (rand.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }

        return ans;
    }
}