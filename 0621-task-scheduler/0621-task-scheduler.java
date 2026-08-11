class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];

        for (char c : tasks) {
            f[c - 'A']++;
        }

        int mx = 0;

        for (int x : f) {
            mx = Math.max(mx, x);
        }

        int cnt = 0;

        for (int x : f) {
            if (x == mx) {
                cnt++;
            }
        }

        int ans = (mx - 1) * (n + 1) + cnt;

        return Math.max(ans, tasks.length);
    }
}