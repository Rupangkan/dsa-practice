class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])
        );
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) free.offer(i);

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (int[] m : meetings) {
            int s = m[0], e = m[1];
            while (!busy.isEmpty() && busy.peek()[0] <= s)
                free.offer((int) busy.poll()[1]);

            if (!free.isEmpty()) {
                int r = free.poll();
                busy.offer(new long[]{e, r});
                cnt[r]++;
            } else {
                long[] x = busy.poll();
                busy.offer(new long[]{x[0] + e - s, x[1]});
                cnt[(int) x[1]]++;
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++)
            if (cnt[i] > cnt[ans]) ans = i;
        return ans;
    }
}
