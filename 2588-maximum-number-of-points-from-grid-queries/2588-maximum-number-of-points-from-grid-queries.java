class Solution {
   public static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int qLen = queries.length, rLen = grid.length, cLen = grid[0].length;
        int n = rLen * cLen, res[] = new int[qLen], thresh[] = new int[n + 1];
        int[][] minReach = new int[rLen][cLen];
        Arrays.stream(minReach).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        minReach[0][0] = grid[0][0];
        
        int cells = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            thresh[++cells] = cur[2];
            for (int[] d : DIR) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nr < rLen && nc >= 0 && nc < cLen && minReach[nr][nc] == Integer.MAX_VALUE) {
                    minReach[nr][nc] = Math.max(cur[2], grid[nr][nc]);
                    pq.offer(new int[]{nr, nc, minReach[nr][nc]});
                }
            }
        }
        
        for (int i = 0; i < qLen; i++) {
            int l = 0, r = n, t = queries[i];
            while (l < r) {
                int m = (l + r + 1) >>> 1;
                if (thresh[m] < t) l = m;
                else r = m - 1;
            }
            res[i] = l;
        }
        return res;
    }
}