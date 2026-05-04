class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
 
        for(int i = 0; i<n; i++) {
            int start = 0, end = n-1;

            while(start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}