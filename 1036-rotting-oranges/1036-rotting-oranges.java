class Orange {
    int x;
    int y;
    int min;

    Orange(int a, int b, int c) {
        x = a;
        y = b;
        min = c;
    }
}

class Solution {
    int bfs(int[][] g, int n, int m) {
        int[][] vis = new int[n][m];
        Queue<Orange> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(g[i][j] == 2) {
                    q.add(new Orange(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if(g[i][j] == 1) count++;
            }
        }

        int[] delR = {-1, 0, 1, 0};
        int[] delC = {0, 1, 0, -1};
        int countF = 0, tMax = 0;

        while(!q.isEmpty()) {
            Orange curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int t = curr.min;
            tMax = Math.max(t, tMax);
            for(int i = 0; i<4; i++) {
                int currX = x + delR[i];
                int currY = y + delC[i];

                if(currX >= 0 && currX < n && currY >= 0 && currY < m && g[currX][currY] == 1 && vis[currX][currY] == 0) {
                    vis[currX][currY] = 1;
                    q.add(new Orange(currX, currY, t+1));
                    countF++;
                }
            }
        }

        if(countF != count) return -1;
        return tMax;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return bfs(grid, n, m);
    }
}