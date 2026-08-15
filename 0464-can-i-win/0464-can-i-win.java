class Solution {
    public boolean canIWin(int max, int target) {
        int sum = max * (max + 1) / 2;

        if (target <= 0) {
            return true;
        }

        if (sum < target) {
            return false;
        }

        Boolean[] dp = new Boolean[1 << max];

        return solve(0, target, max, dp);
    }

    private boolean solve(int mask, int target, int max, Boolean[] dp) {
        if (dp[mask] != null) {
            return dp[mask];
        }

        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);

            if ((mask & bit) == 0) {
                if (i >= target || !solve(mask | bit, target - i, max, dp)) {
                    dp[mask] = true;
                    return true;
                }
            }
        }

        dp[mask] = false;
        return false;
    }
}