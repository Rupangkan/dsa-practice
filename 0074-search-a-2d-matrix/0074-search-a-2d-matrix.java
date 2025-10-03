class Solution {
    public boolean searchMatrix(int[][] mat, int t) {
        int n = mat.length;
        int m = mat[0].length;

        int high = n * m - 1;
        int low = 0;

        while(low <= high) {
            int mid = (high + low)/2;
            int row = mid/m;
            int col = mid%m;

            if(mat[row][col] == t) return true;
            else if(mat[row][col] > t) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}