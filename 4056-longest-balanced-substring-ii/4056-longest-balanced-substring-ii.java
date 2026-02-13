class Solution {

    public int longestBalanced(String s) {
        char[] a = s.toCharArray();
        int n = a.length;

        int ca = 0, cb = 0, cc = 0;
        int ma = 0, mb = 0, mc = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 'a') {
                ca = (i > 0 && a[i - 1] == 'a') ? ca + 1 : 1;
                ma = Math.max(ma, ca);
            } else if (a[i] == 'b') {
                cb = (i > 0 && a[i - 1] == 'b') ? cb + 1 : 1;
                mb = Math.max(mb, cb);
            } else {
                cc = (i > 0 && a[i - 1] == 'c') ? cc + 1 : 1;
                mc = Math.max(mc, cc);
            }
        }

        int ans = Math.max(ma, Math.max(mb, mc));

        ans = Math.max(ans, two(a, 'a', 'b'));
        ans = Math.max(ans, two(a, 'a', 'c'));
        ans = Math.max(ans, two(a, 'b', 'c'));
        ans = Math.max(ans, three(a));

        return ans;
    }

    int two(char[] a, char x, char y) {
        int n = a.length, res = 0;
        int[] first = new int[2 * n + 5];
        Arrays.fill(first, -2);

        int base = n, diff = base;
        int lastBad = -1;
        first[diff] = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] != x && a[i] != y) {
                lastBad = i;
                diff = base;
                first[diff] = lastBad;
            } else {
                diff += (a[i] == x ? 1 : -1);
                if (first[diff] < lastBad) {
                    first[diff] = i;
                } else {
                    res = Math.max(res, i - first[diff]);
                }
            }
        }
        return res;
    }

    int three(char[] a) {
        long state = 0;
        Map<Long, Integer> first = new HashMap<>();
        first.put(0L, -1);

        int res = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'a') state += 1_000_003L;
            else if (a[i] == 'b') state -= 1_000_000L;
            else state -= 3;

            Integer prev = first.get(state);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                first.put(state, i);
            }
        }
        return res;
    }
}
