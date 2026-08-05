class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int l, int r, int k) {
        if (r - l < k) return 0;

        int[] f = new int[26];

        for (int i = l; i < r; i++) {
            f[s.charAt(i) - 'a']++;
        }

        for (int i = l; i < r; i++) {
            if (f[s.charAt(i) - 'a'] < k) {
                int j = i + 1;

                while (j < r && f[s.charAt(j) - 'a'] < k) {
                    j++;
                }

                return Math.max(solve(s, l, i, k), solve(s, j, r, k));
            }
        }

        return r - l;
    }
}