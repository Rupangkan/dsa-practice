class Solution {

    public int countPartitions(int[] a, int k) {
        int n = a.length;
        final long MOD = 1_000_000_007L;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        Deque<Integer> mn = new ArrayDeque<>();
        Deque<Integer> mx = new ArrayDeque<>();

        dp[0] = pref[0] = 1;
        int j = 0;

        for (int i = 0; i < n; i++) {

            while (!mx.isEmpty() && a[mx.peekLast()] <= a[i]) mx.pollLast();
            mx.addLast(i);

            while (!mn.isEmpty() && a[mn.peekLast()] >= a[i]) mn.pollLast();
            mn.addLast(i);

            while (a[mx.peekFirst()] - a[mn.peekFirst()] > k) {
                if (mx.peekFirst() == j) mx.pollFirst();
                if (mn.peekFirst() == j) mn.pollFirst();
                j++;
            }

            long valid = pref[i] - (j > 0 ? pref[j - 1] : 0);
            if (valid < 0) valid += MOD;
            dp[i + 1] = valid;

            pref[i + 1] = (pref[i] + valid) % MOD;
        }
        return (int) dp[n];
    }
}
