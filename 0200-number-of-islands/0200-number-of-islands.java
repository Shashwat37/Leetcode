class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int r = cur[0] + dr[k];
                            int c = cur[1] + dc[k];

                            if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                q.offer(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}