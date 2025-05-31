class Solution {
   private int solve(int[][] a) {
        int n = a.length, goal = n * n;
        int[] map = new int[goal + 1];
        int idx = 1, dir = 1;
        for (int r = n - 1; r >= 0; r--) {
            if (dir == 1) {
                for (int c = 0; c < n; c++) map[idx++] = a[r][c];
            } else {
                for (int c = n - 1; c >= 0; c--) map[idx++] = a[r][c];
            }
            dir ^= 1;
        }

        int[] vis = new int[goal + 1];
        Arrays.fill(vis, -1);
        vis[1] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int d = 1; d <= 6 && cur + d <= goal; d++) {
                int next = cur + d;
                if (map[next] > 0) next = map[next];
                if (vis[next] == -1) {
                    vis[next] = vis[cur] + 1;
                    q.offer(next);
                }
            }
        }
        return vis[goal];
    }
    
    public int snakesAndLadders(int[][] board) {
        return solve(board);
    }
}