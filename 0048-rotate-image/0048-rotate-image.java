class Solution {

    private void swap(int[][] nums, int ind1, int ind2) {
        int t = nums[ind1][ind2];
        nums[ind1][ind2] = nums[ind2][ind1];
        nums[ind2][ind1] = t;
    }

    private void swapRow(int[][] nums, int ind1, int ind2, int rowNum) {
        int t = nums[rowNum][ind2];
        nums[rowNum][ind2] = nums[rowNum][ind1];
        nums[rowNum][ind1] = t;
    }

    private void reverse(int[][] mat, int ind) {
        int start = 0, end = mat.length - 1;

        while(start<end) {
            swapRow(mat, start, end, ind);
            start++;
            end--;
        }
    }

    public void rotate(int[][] mat) {
        int n = mat.length;

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