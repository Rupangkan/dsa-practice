class Pair {
    int r;
    int c;
    Pair(int t, int s) {
        r = t;
        c = s;
    }
    int getR() {
        return r;
    }
    int getC() {
        return c;
    }
}
 
class Solution {
    public static void markRows(int[][] m, int i) {
        for(int j = 0; j<m[i].length; j++) {
            if(m[i][j] != 0) {
                m[i][j] = -1;
            }
        }
    }

    public static void markCols(int[][] m, int j) {
        for(int i = 0; i<m.length; i++) {
            if(m[i][j] != 0) {
                m[i][j] = -1;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        if(matrix.length < 1) return;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                } 
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
   
    }
}