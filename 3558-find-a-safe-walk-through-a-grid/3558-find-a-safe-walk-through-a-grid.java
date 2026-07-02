class Solution {

    class Pair {
        int i;
        int j;
        int h;
        Pair(int x, int y, int k) {
            i = x; 
            j = y;
            h = k;
        }
    }

    public boolean bfs(int n, int m, List<List<Integer>> grid, int h) {
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        for(int[] arr: vis) Arrays.fill(arr, -1);
        vis[0][0] = h;
        if(grid.get(0).get(0) == 1) vis[0][0] = h-1;
        q.add(new Pair(0, 0, vis[0][0]));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int currH = p.h;

            if(i == n-1 && j == m-1) {
                if(currH > 0) return true;
            }

            for(int x = 0; x<4; x++) {
                int nRow = i + delRow[x];
                int nCol = j + delCol[x];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int newH = currH - grid.get(nRow).get(nCol);
                    System.out.println(newH + " ");
                    if(newH > 0 && newH > vis[nRow][nCol]) {
                        vis[nRow][nCol] = newH;
                        q.offer(new Pair(nRow, nCol, newH));
                    }
                }
            }
        }
        return false;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        return bfs(n, m, grid, health);
    }
}