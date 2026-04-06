class Solution {

    private static final long M = 60013;

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        for (int[] o : obstacles) set.add(h(o[0], o[1]));

        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0, x = 0, y = 0, ans = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) & 3;
            } else if (cmd == -2) {
                dir = (dir + 3) & 3;
            } else {
                int dx = d[dir][0], dy = d[dir][1];
                for (int k = 0; k < cmd; k++) {
                    int nx = x + dx, ny = y + dy;
                    if (set.contains(h(nx, ny))) break;
                    x = nx;
                    y = ny;
                }
                ans = Math.max(ans, x * x + y * y);
            }
        }

        return ans;
    }

    private long h(long x, long y) {
        return x + M * y;
    }
}