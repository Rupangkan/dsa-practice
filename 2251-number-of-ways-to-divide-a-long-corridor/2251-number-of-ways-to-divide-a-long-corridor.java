class Solution {
    public int numberOfWays(String s) {
        int n = s.length(), seats = 0, last = -1;
        long ans = 1, mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'S') {
                seats++;
                if (seats == 2) {
                    last = i;
                    seats = 0;
                } else if (seats == 1 && last != -1) {
                    ans = ans * (i - last) % mod;
                }
            }
        }
        if (seats == 1 || last == -1) return 0;
        return (int) ans;
    }
}
