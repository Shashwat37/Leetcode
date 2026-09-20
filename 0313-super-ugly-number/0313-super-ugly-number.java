class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;

        int[] dp = new int[n];
        int[] idx = new int[m];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                long x = (long) primes[j] * dp[idx[j]];

                if (x < min) {
                    min = x;
                }
            }

            dp[i] = (int) min;

            for (int j = 0; j < m; j++) {
                long x = (long) primes[j] * dp[idx[j]];

                if (x == min) {
                    idx[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}