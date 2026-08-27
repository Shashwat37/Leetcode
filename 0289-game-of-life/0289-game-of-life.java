class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int cnt = 0;

                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (x == 0 && y == 0) continue;

                        int r = i + x;
                        int c = j + y;

                        if (r >= 0 && r < n && c >= 0 && c < m &&
                            (board[r][c] == 1 || board[r][c] == 2)) {
                            cnt++;
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (cnt < 2 || cnt > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (cnt == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}