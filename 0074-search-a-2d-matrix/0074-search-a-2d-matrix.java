class Solution {
    public boolean brute(int[][] mat, int t) {
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

    private boolean binarySearch(int[][] mat, int i, int t, int low, int high) {
        while(low<=high) {
            int mid = (high+low)/2;
            if(mat[i][mid] == t) return true;
            if(mat[i][mid] > t) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }  

    // better would be to go through every row then apply binary search on it.
    private boolean better(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int high = m-1;
        int low = 0;

        for(int i = 0; i<n; i++) {
            if(mat[i][0] <= t && mat[i][m-1] >=t) 
                return binarySearch(mat, i, t, low, high);
        }
        return false;
    }
    
    // flatten the matrix hypothetically,
    // row = ind / m (col size) 
    // col = ind % m (col size)
    private boolean optimal(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = (n*m)-1;
  
        while(low<=high) {
            int mid = (high+low)/2;
            int row = mid / m, col = mid % m;
            if(mat[row][col] == t) return true;
            else if(mat[row][col] > t) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] mat, int t) {
        // return brute(mat, t);
        // return better(mat, t);
        return optimal(mat, t);
    }
}