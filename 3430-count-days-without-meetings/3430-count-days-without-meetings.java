class Solution {
    public int countDays(int days, int[][] meetings) {
        int f = 0, e = 0;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for(int[] m: meetings) {
            int s = m[0], l = m[1];

            if(s > e + 1) f += s - e - 1;

            e = Math.max(e, l);
        }

        f += days - e;
        return f;
    }
}