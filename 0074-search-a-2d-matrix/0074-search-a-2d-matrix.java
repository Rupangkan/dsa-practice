class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = n*m-1;

        while(low <= high) {
            int mid = (low + high)/2;

            int row = mid / m, col = mid % m;
            if(mat[row][col] < target) {
                low = mid + 1;
            } else if(mat[row][col] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}