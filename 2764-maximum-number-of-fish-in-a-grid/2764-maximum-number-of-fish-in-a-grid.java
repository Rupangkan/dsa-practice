class Solution {

    int find(int[] parent, int x) {
        return parent[x] == x ? x: (parent[x] = find(parent, parent[x]));
    }


    private void union(int[] parent, int[] size, int[] fish, int x, int y) {
        int px = find(parent, x), py = find(parent, y);
        if (px != py) {
            if (size[px] < size[py]) {
                int temp = px;
                px = py;
                py = temp;
            }
            parent[py] = px;
            size[px] += size[py];
            fish[px] += fish[py];
        }
    }

    public int findMaxFish(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, n = rows * cols;
        int[] parent = new int[n], size = new int[n], fish = new int[n];

        for(int i = 0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int r = 0; r<rows; r++) {
            for(int c = 0; c<cols; c++) {
                int idx = r * cols + c;
                fish[idx] = grid[r][c];
            }
        }

        int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};

        for(int r = 0; r<rows; r++) {
            for(int c = 0; c<cols; c++) {
                if (grid[r][c] > 0) {
                    int idx = r * cols + c;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d], nc = c + dc[d];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] > 0) {
                            union(parent, size, fish, idx, nr * cols + nc);
                        }
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i<n; i++) {
            if(find(parent, i) == i) max = Math.max(max, fish[i]);
        }

        return max;
    }
}