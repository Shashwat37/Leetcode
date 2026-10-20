class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;

        for (int x : nums) {
            int l = 0;
            int r = len;

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (dp[mid] < x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            dp[l] = x;

            if (l == len) {
                len++;
            }
        }

        return len;
    }
}