class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, maxLeft = values[0], max = 0;

        for(int i = 1; i<n; i++) {
            int curr = values[i] - i;
            max = Math.max(max, maxLeft + curr);
            int currLeft = values[i] + i;
            maxLeft = Math.max(maxLeft, currLeft);
        }

        return max;
    }
}