class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int mn = nums[0];
        int mx = nums[0];

        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }

        if (mn == mx) {
            return 0;
        }

        int gap = (mx - mn + n - 2) / (n - 1);

        int[] bmin = new int[n];
        int[] bmax = new int[n];
        boolean[] used = new boolean[n];

        Arrays.fill(bmin, Integer.MAX_VALUE);
        Arrays.fill(bmax, Integer.MIN_VALUE);

        for (int x : nums) {
            int idx = (x - mn) / gap;

            bmin[idx] = Math.min(bmin[idx], x);
            bmax[idx] = Math.max(bmax[idx], x);
            used[idx] = true;
        }

        int ans = 0;
        int prev = mn;

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                continue;
            }

            ans = Math.max(ans, bmin[i] - prev);
            prev = bmax[i];
        }

        return ans;
    }
}