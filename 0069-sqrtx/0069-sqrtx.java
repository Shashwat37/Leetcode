class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int l = 1;
        int r = x / 2;
        int ans = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if ((long) m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }
}