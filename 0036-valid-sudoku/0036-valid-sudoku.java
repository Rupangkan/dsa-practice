class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] r = new boolean[9][9], c = new boolean[9][9], b = new boolean[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                char ch = board[x][y];
                if (ch == '.') continue;
                int d = ch - '1';
                int idx = (x / 3) * 3 + (y / 3);
                if (r[x][d] || c[y][d] || b[idx][d]) return false;
                r[x][d] = c[y][d] = b[idx][d] = true;
            }
        }
        return true;
    }
}