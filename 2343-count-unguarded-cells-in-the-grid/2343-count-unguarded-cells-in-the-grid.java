class Solution {
    void mark(int r, int c, int[][] mat, int wall, int guard, int guarded, int unguarded) {
        for(int i = r-1; i>=0; i--) {
            if(mat[i][c] == wall || mat[i][c] == guard) break;
            mat[i][c] = guarded;
        }

        for(int i = r+1; i<mat.length; i++) {
            if(mat[i][c] == wall || mat[i][c] == guard) break;
            mat[i][c] = guarded;
        }

        for(int i = c-1; i>=0; i--) {
            if(mat[r][i] == wall || mat[r][i] == guard) break;
            mat[r][i] = guarded;
        }

        for(int i = c+1; i<mat[0].length; i++) {
            if(mat[r][i] == wall || mat[r][i] == guard) break;
            mat[r][i] = guarded;
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        int guard = 4, wall = 2, guarded = 3, unguarded = 0, count = 0;

        for(int[] g: guards) mat[g[0]][g[1]] = guard;

        for(int[] w: walls) mat[w[0]][w[1]] = wall;

        for(int[] g: guards) {
            mark(g[0], g[1], mat, wall, guard, guarded, unguarded);
        }

        for(int[] r: mat) {
            for(int c: r) {
                if(c == unguarded) count++;
            }
        }

        return count;
    }
}