class Solution {
    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {1, 0, -1, 0};

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] id = new int[m][n];

        int sx = 0, sy = 0, lights = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    id[i][j] = 1 << lights++;
                }
            }
        }

        int full = (1 << lights) - 1;
        int[][][] best = new int[m][n][full + 1];

        for (int[][] row : best) {
            for (int[] state : row) {
                Arrays.fill(state, -1);
            }
        }

        best[sx][sy][0] = energy;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {sx, sy, 0, energy, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int steps = cur[4];

            if (mask == full) {
                return steps;
            }

            if (e == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + DX[d];
                int ny = y + DY[d];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n ||
                    classroom[nx].charAt(ny) == 'X') {
                    continue;
                }

                char cell = classroom[nx].charAt(ny);
                int ne = cell == 'R' ? energy : e - 1;
                int nmask = mask | id[nx][ny];

                if (ne > best[nx][ny][nmask]) {
                    best[nx][ny][nmask] = ne;
                    q.offer(new int[] {nx, ny, nmask, ne, steps + 1});
                }
            }
        }

        return -1;
    }
}