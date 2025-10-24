class Solution {
    private boolean isValid(char[][] board, int n, int row, int col, char a) {
        for(int i = 0; i<n; i++) {
            if(board[i][col] == a) return false;
            if(board[row][i] == a) return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == a) return false;
        }
        return true;
    }

    private boolean test(int n, char[][] board) {
        for(int row = 0; row<n; row++) {
            for(int col = 0; col<n; col++) {
                if(board[row][col] == '.') {
                    for(char a = '1'; a<='9'; a++) {
                        if(isValid(board, n, row, col, a)) {
                            board[row][col] = a;
                            if(test(n, board)) return true;
                            else board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;
        test(n, board);
    }
}