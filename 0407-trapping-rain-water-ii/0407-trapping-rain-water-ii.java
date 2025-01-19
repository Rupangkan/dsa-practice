class Solution {

    public int trapRainWater(int[][] grid) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        PriorityQueue<Cell> pq = new PriorityQueue<>();

        for (int i = 0; i < rows; i++) {
            pq.offer(new Cell(grid[i][0], i, 0));
            pq.offer(new Cell(grid[i][cols - 1], i, cols - 1));
            vis[i][0] = vis[i][cols - 1] = true;
        }

        for (int i = 0; i < cols; i++) {
            pq.offer(new Cell(grid[0][i], 0, i));
            pq.offer(new Cell(grid[rows - 1][i], rows - 1, i));
            vis[0][i] = vis[rows - 1][i] = true;
        }

        int water = 0;

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            int x = curr.r, y = curr.c, h = curr.h;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (isValid(nx, ny, rows, cols) && !vis[nx][ny]) {
                    int nh = grid[nx][ny];
                    if (nh < h) {
                        water += h - nh;
                    }
                    pq.offer(new Cell(Math.max(nh, h), nx, ny));
                    vis[nx][ny] = true;
                }
            }
        }

        return water;
    }

    private static class Cell implements Comparable<Cell> {
        int h, r, c;
        public Cell(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.h, o.h);
        }
    }

    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }
}