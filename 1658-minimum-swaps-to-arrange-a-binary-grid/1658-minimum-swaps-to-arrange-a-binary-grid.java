class Solution {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] rightmostOne = new int[n];
        Arrays.fill(rightmostOne, -1);

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    rightmostOne[i] = j;
                    break;
                }
            }
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int row = -1;

            for (int j = i; j < n; j++) {
                if (rightmostOne[j] <= i) {
                    row = j;
                    break;
                }
            }

            if (row == -1) return -1;

            swaps += row - i;

            while (row > i) {
                int temp = rightmostOne[row];
                rightmostOne[row] = rightmostOne[row - 1];
                rightmostOne[row - 1] = temp;
                row--;
            }
        }

        return swaps;
    }
}
