class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int h = maxConsecutive(hBars);
        int v = maxConsecutive(vBars);

        int side = Math.min(h, v) + 1;
        return side * side;
    }

    private int maxConsecutive(int[] a) {
        int cur = 1, best = 1;
        for (int i = 1; i < a.length; i++) {
            cur = (a[i] == a[i - 1] + 1) ? cur + 1 : 1;
            best = Math.max(best, cur);
        }
        return best;
    }
}
