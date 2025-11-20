class Solution {
    public int intersectionSizeTwo(int[][] a) {
        Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : y[1] - x[1]);
        int n = a.length, ans = 0;
        int[] need = new int[n];
        Arrays.fill(need, 2);

        for (int i = n - 1; i >= 0; i--) {
            int l = a[i][0], r = a[i][1], k = need[i];
            for (int p = l; p < l + k; p++) {
                ans++;
                for (int j = 0; j <= i; j++) {
                    if (need[j] > 0 && p <= a[j][1]) need[j]--;
                }
            }
        }
        return ans;
    }
}
