class Solution {

    private void swap(int[][] mat, int row, int start, int end) {
        int temp = mat[row][start];
        mat[row][start] = mat[row][end];
        mat[row][end] = temp;
    }

    private void reverse(int[][] mat, int row) {
        int start = 0, end = mat[0].length-1;
        while(start < end) {
            swap(mat, row, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[][] mat, int ind1, int ind2) {
        int temp = mat[ind1][ind2];
        mat[ind1][ind2] = mat[ind2][ind1];
        mat[ind2][ind1] = temp;
    }

    public void rotate(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<i; j++) {
                swap(mat, i, j);
            }
        }

        for(int i = 0; i<n; i++) {
            reverse(mat, i);
        }
    }
}