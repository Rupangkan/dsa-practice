class Solution {

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x < 0 || x >= n || vis[x]) continue;
            if (arr[x] == 0) return true;

            vis[x] = true;

            q.offer(x + arr[x]);
            q.offer(x - arr[x]);
        }

        return false;
    }
}