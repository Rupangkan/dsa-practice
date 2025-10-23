class Solution {
    private void solve(int col, int n, List<List<String>> ans, char[][] board, boolean[] left, boolean[] upper, boolean[] lower) {
        if(col == n) {
            List<String> temp = new ArrayList<>();

            for(int i = 0; i<n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int row = 0; row<n; row++) {
            if(upper[(n-1)+(col-row)] == false && lower[row+col] == false && left[row] == false) {
                board[row][col] = 'Q';
                upper[(n-1)+(col-row)] = true;
                lower[row+col] = true;
                left[row] = true;
                solve(col + 1, n, ans, board, left, upper, lower);
                board[row][col] = '.';
                upper[(n-1)+(col-row)] = false;
                lower[row+col] = false;
                left[row] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // List<String> board = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        boolean[] left = new boolean[n+1];
        boolean[] upper = new boolean[2*n-1];
        boolean[] lower = new boolean[2*n-1];
        int col = 0;

        solve(col, n, ans, board, left, upper, lower);
        return ans;
    }
}