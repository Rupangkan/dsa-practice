class Solution {

    private int bfs(int[] s, int[] c, int[][] k, int[][] b, int[] init) {
        int n = s.length, res = 0;
        boolean[] open = new boolean[n], box = new boolean[n], used = new boolean[n];
        for (int i = 0; i < n; i++) open[i] = s[i] == 1;
        Queue<Integer> q = new ArrayDeque<>();
        for (int x : init) {
            box[x] = true;
            if (open[x]) {
                q.add(x);
                used[x] = true;
                res += c[x];
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int y : k[u]) {
                open[y] = true;
                if (box[y] && !used[y]) {
                    q.add(y);
                    used[y] = true;
                    res += c[y];
                }
            }
            for (int y : b[u]) {
                box[y] = true;
                if (open[y] && !used[y]) {
                    q.add(y);
                    used[y] = true;
                    res += c[y];
                }
            }
        }
        return res;
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        return bfs(status, candies, keys, containedBoxes, initialBoxes);
    }
}