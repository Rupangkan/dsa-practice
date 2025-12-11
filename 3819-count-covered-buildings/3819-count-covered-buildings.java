class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] mxR = new int[n + 1], mnR = new int[n + 1];
        int[] mxC = new int[n + 1], mnC = new int[n + 1];

        Arrays.fill(mnR, n + 1);
        Arrays.fill(mnC, n + 1);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            mxR[y] = Math.max(mxR[y], x);
            mnR[y] = Math.min(mnR[y], x);
            mxC[x] = Math.max(mxC[x], y);
            mnC[x] = Math.min(mnC[x], y);
        }

        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (x > mnR[y] && x < mxR[y] && y > mnC[x] && y < mxC[x]) ans++;
        }
        return ans;
    }
}
