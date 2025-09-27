class Solution {

    private void swap(int[][] mat, int ind1, int ind2) {
        int t = mat[ind1][ind2];
        mat[ind2][ind1] = mat[ind1][ind2];
        mat[ind1][ind2] = t;
    }

    private void reverse(int[][] mat) {
        int n = mat.length;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n/2; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[i][n-1-j];
                mat[i][n-1-j] = t;
            }
        }
    }

    // Transpose + reverse
    private void optimal(int[][] mat) {
        int n = mat.length;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<i; j++) {
                // swap(mat, i, j);
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }
        reverse(mat);
    }

    private void brute(int[][] mat) {
        int n = mat.length;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                mat[j][(n-1)-i] = mat[i][j];
            }
        }

    }

    public void rotate(int[][] matrix) {
        // brute(matrix);
        optimal(matrix);
    }
}

// m[0][0] == m[0][2]
// m[1][0] == m[0][1]
// m[2][0] == m[0][0]

// m[0][2] == m[2][2]
// m[1][2] == m[2][1]
// m[2][2] == m[0][2]