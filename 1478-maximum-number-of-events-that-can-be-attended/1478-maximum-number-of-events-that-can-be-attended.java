class Solution {
    private int solve(int[][] ev) {
        int n = ev.length, d = 0;
        for (int[] e : ev) d = Math.max(d, e[1]);

        Arrays.sort(ev, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int res = 0, idx = 0;

        for (int day = 1; day <= d; day++) {
            while (idx < n && ev[idx][0] <= day) q.offer(ev[idx++][1]);
            while (!q.isEmpty() && q.peek() < day) q.poll();
            if (!q.isEmpty()) {
                q.poll();
                res++;
            }
        }
        return res;
    }

    public int maxEvents(int[][] events) {
        return solve(events);
    }
}