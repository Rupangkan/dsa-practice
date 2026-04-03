class Solution {

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length, m = walls.length;

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = robots[i];
            a[i][1] = distance[i];
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        Arrays.sort(walls);

        int l = 0, r = 0, c = 0, p = 0;
        int subL = 0, subR = 0;
        int prevL = 0, prevR = 0;

        for (int i = 0; i < n; i++) {
            int pos = a[i][0], d = a[i][1];

            while (r < m && walls[r] <= pos) r++;
            int p1 = r;

            while (c < m && walls[c] < pos) c++;
            int p2 = c;

            int lb = pos - d;
            if (i > 0) lb = Math.max(lb, a[i - 1][0] + 1);
            while (l < m && walls[l] < lb) l++;
            int curL = p1 - l;

            int rb = pos + d;
            if (i < n - 1) rb = Math.min(rb, a[i + 1][0] - 1);
            while (r < m && walls[r] <= rb) r++;
            int curR = r - p2;

            int curNum = 0;
            if (i > 0) {
                while (p < m && walls[p] < a[i - 1][0]) p++;
                curNum = p1 - p;
            }

            if (i == 0) {
                subL = curL;
                subR = curR;
            } else {
                int nL = Math.max(subL + curL,
                        subR - prevR + Math.min(curL + prevR, curNum));
                int nR = Math.max(subL + curR, subR + curR);
                subL = nL;
                subR = nR;
            }

            prevL = curL;
            prevR = curR;
        }

        return Math.max(subL, subR);
    }
}