class Solution {

    class Pair {
        int x;
        int y;
        int min;

        Pair(int a, int b, int c) {
            x = a;
            y = b;
            min = c;
        }
    }

    public int solveBfs(int[][] moveTime, int[][] vis, int n, int m) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.min - b.min);
        q.add(new Pair(0, 0, 0));
        
        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, 1, 0, -1};

        vis[0][0] = 0;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = p.min;
            // System.out.println(x + " " + y + " " + z);
            if(z > vis[x][y]) continue;

            // if(x == n-1 && y == m-1) return z;
            
            for(int i = 0; i<4; i++) {
                int nRow = x + delRow[i];
                int nCol = y + delCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int newTime = Math.max(z, moveTime[nRow][nCol]) + 1;

                    if(newTime < vis[nRow][nCol]) {
                        // System.out.println(x + " " + y + " " + z + " " + nRow + " " + nCol + " " + newTime);
                        
                        vis[nRow][nCol] = newTime;
                        q.offer(new Pair(nRow, nCol, newTime));
                    }
                }
            }
        }

        return vis[n-1][m-1];
    }
    
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] vis = new int[n][m];

        for(int[] arr: vis) Arrays.fill(arr, Integer.MAX_VALUE);

        return solveBfs(moveTime, vis, n, m);
    }
}