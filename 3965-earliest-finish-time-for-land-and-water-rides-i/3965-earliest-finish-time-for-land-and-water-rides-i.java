class Solution {

    private int calc(int[] s1, int[] d1, int[] s2, int[] d2) {
        int t = Integer.MAX_VALUE;

        for (int i = 0; i < s1.length; i++) {
            t = Math.min(t, s1[i] + d1[i]);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < s2.length; i++) {
            res = Math.min(res, Math.max(s2[i], t) + d2[i]);
        }

        return res;
    }

    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {
        int a = calc(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration
        );

        int b = calc(
            waterStartTime,
            waterDuration,
            landStartTime,
            landDuration
        );

        return Math.min(a, b);
    }
}