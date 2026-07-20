class Solution {
    public int countPalindromes(String s) {
        int n = s.length();
        int mod = 1000000007;

        int[][][] pre = new int[n][10][10];
        int[][][] suf = new int[n][10][10];

        int[] cnt = new int[10];

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                for (int a = 0; a < 10; a++) {
                    for (int b = 0; b < 10; b++) {
                        pre[i][a][b] = pre[i - 1][a][b];
                    }
                }
            }

            int d = s.charAt(i) - '0';

            for (int a = 0; a < 10; a++) {
                pre[i][a][d] += cnt[a];
            }

            cnt[d]++;
        }

        cnt = new int[10];

        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                for (int a = 0; a < 10; a++) {
                    for (int b = 0; b < 10; b++) {
                        suf[i][a][b] = suf[i + 1][a][b];
                    }
                }
            }

            int d = s.charAt(i) - '0';

            for (int b = 0; b < 10; b++) {
                suf[i][d][b] += cnt[b];
            }

            cnt[d]++;
        }

        long ans = 0;

        for (int i = 2; i <= n - 3; i++) {
            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    ans = (ans + (long) pre[i - 1][a][b] * suf[i + 1][b][a]) % mod;
                }
            }
        }

        return (int) ans;
    }
}