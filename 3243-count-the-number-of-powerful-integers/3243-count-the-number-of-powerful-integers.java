class Solution {

    private long solve(String x, String s, int lim) {
        if (x.length() < s.length()) return 0;
        if (x.length() == s.length()) return x.compareTo(s) >= 0 ? 1 : 0;

        int len = x.length() - s.length();
        long ans = 0;

        for (int i = 0; i < len; i++) {
            int d = x.charAt(i) - '0';
            for (int j = 0; j < d && j <= lim; j++) {
                ans += pow(lim + 1, len - i - 1);
            }
            if (d > lim) return ans;
        }

        if (x.substring(len).compareTo(s) >= 0) ans++;
        return ans;
    }

    private long pow(int base, int exp) {
        long res = 1;
        while (exp-- > 0) res *= base;
        return res;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String st = Long.toString(start-1);
        String f = Long.toString(finish);
        return solve(f, s, limit) - solve(st, s, limit);
    }
}