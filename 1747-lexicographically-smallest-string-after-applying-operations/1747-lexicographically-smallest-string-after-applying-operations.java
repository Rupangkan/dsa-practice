public class Solution {

    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String best = s;
        s += s;
        int step = gcd(b, n);

        for (int i = 0; i < n; i += step) {
            char[] arr = s.substring(i, i + n).toCharArray();
            tweak(arr, n, a, 1);
            if ((b & 1) == 1) tweak(arr, n, a, 0);
            String cur = new String(arr);
            if (cur.compareTo(best) < 0) best = cur;
        }
        return best;
    }

    private void tweak(char[] arr, int n, int a, int st) {
        int min = 10, cnt = 0;
        for (int i = 0; i < 10; i++) {
            int val = ((arr[st] - '0') + i * a) % 10;
            if (val < min) {
                min = val;
                cnt = i;
            }
        }
        for (int i = st; i < n; i += 2)
            arr[i] = (char) ('0' + (((arr[i] - '0') + cnt * a) % 10));
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
