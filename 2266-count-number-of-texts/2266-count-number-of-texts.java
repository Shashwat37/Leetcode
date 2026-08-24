class Solution {
    public int countTexts(String pressedKeys) {
        long mod = 1000000007;
        int n = pressedKeys.length();

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char c = pressedKeys.charAt(i - 1);
            int max = (c == '7' || c == '9') ? 4 : 3;

            for (int j = 1; j <= max && i - j >= 0; j++) {
                if (pressedKeys.charAt(i - j) != c) {
                    break;
                }

                dp[i] = (dp[i] + dp[i - j]) % mod;
            }
        }

        return (int) dp[n];
    }
}