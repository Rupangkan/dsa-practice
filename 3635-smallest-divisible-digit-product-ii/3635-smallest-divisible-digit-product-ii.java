class Solution {
    public String smallestNumber(String num, long t) {
        long x = t;
        for (int i = 2; i <= 9; i++)
            while (x % i == 0)
                x /= i;

        if (x > 1) return "-1";

        int n = num.length(), pos = n - 1;
        char[] s = num.toCharArray();
        long[] rem = new long[n + 1];
        rem[0] = t;

        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                pos = i;
                break;
            }
            rem[i + 1] = rem[i] / gcd(rem[i], s[i] - '0');
        }

        if (rem[n] == 1) return num;

        for (int i = pos; i >= 0; i--) {
            while (++s[i] <= '9') {
                long cur = rem[i] / gcd(rem[i], s[i] - '0');
                int d = 9;

                for (int j = n - 1; j > i; j--) {
                    while (cur % d != 0) d--;
                    cur /= d;
                    s[j] = (char) (d + '0');
                }

                if (cur == 1) return new String(s);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (t > 1) {
            for (int d = 9; d >= 2; d--) {
                if (t % d == 0) {
                    ans.append((char) (d + '0'));
                    t /= d;
                    break;
                }
            }
        }

        while (ans.length() < n + 1)
            ans.append('1');

        return ans.reverse().toString();
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}