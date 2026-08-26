class Solution {
    public int[] findOrder(int n, int[][] p) {
        List<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        int[] in = new int[n];

        for (int[] x : p) {
            g[x[1]].add(x[0]);
            in[x[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[n];
        int k = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            ans[k++] = x;

            for (int y : g[x]) {
                in[y]--;

                if (in[y] == 0) {
                    q.add(y);
                }
            }
        }

        return k == n ? ans : new int[0];
    }
}