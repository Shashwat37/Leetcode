class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];

                if (dx * dx + dy * dy <=
                    (long) bombs[i][2] * bombs[i][2]) {
                    g[i].add(j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            Queue<Integer> q = new LinkedList<>();

            q.offer(i);
            vis[i] = true;

            int cnt = 0;

            while (!q.isEmpty()) {
                int x = q.poll();
                cnt++;

                for (int y : g[x]) {
                    if (!vis[y]) {
                        vis[y] = true;
                        q.offer(y);
                    }
                }
            }

            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}