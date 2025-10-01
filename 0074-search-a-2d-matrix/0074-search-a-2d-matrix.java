class Solution {
    public boolean better(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        for(int i = 0; i<n; i++) {
            if(mat[i][0] == t) return true;
            if(mat[i][m-1] == t) return true;
            if(mat[i][m-1] > t) {
                for(int j = 0; j<m; j++) {
                    if(mat[i][j] == t) return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return better(matrix, target);
    }
}