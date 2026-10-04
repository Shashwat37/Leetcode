class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int one = 0;

            for (int x : nums) {
                if ((x & (1 << i)) != 0) {
                    one++;
                }
            }

            int zero = nums.length - one;

            ans += one * zero;
        }

        return ans;
    }
}