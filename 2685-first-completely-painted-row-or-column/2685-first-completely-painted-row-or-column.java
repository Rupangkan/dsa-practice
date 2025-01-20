class Solution {
   public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            posMap.put(arr[i], i);
        }

        int minIndex = Integer.MAX_VALUE;
        int rows = mat.length;
        int cols = mat[0].length;

        for (int r = 0; r < rows; r++) {
            int maxIdx = Integer.MIN_VALUE;
            for (int c = 0; c < cols; c++) {
                maxIdx = Math.max(maxIdx, posMap.get(mat[r][c]));
            }
            minIndex = Math.min(minIndex, maxIdx);
        }

        for (int c = 0; c < cols; c++) {
            int maxIdx = Integer.MIN_VALUE;
            for (int r = 0; r < rows; r++) {
                maxIdx = Math.max(maxIdx, posMap.get(mat[r][c]));
            }
            minIndex = Math.min(minIndex, maxIdx);
        }

        return minIndex;
    }
}