public class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        int[][] pre = new int[n][3];
        int[][] suf = new int[n][3];
        int seg = 0, mask = 0, cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            if ((mask & bit) == 0) {
                if (++cnt > k) {
                    seg++;
                    cnt = 1;
                    mask = bit;
                } else mask |= bit;
            }
            pre[i + 1][0] = seg;
            pre[i + 1][1] = mask;
            pre[i + 1][2] = cnt;
        }

        seg = 0; mask = 0; cnt = 0;
        for (int i = n - 1; i > 0; i--) {
            int bit = 1 << (s.charAt(i) - 'a');
            if ((mask & bit) == 0) {
                if (++cnt > k) {
                    seg++;
                    cnt = 1;
                    mask = bit;
                } else mask |= bit;
            }
            suf[i - 1][0] = seg;
            suf[i - 1][1] = mask;
            suf[i - 1][2] = cnt;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = pre[i][0] + suf[i][0] + 2;
            int all = pre[i][1] | suf[i][1];
            int bits = Integer.bitCount(all);
            if (pre[i][2] == k && suf[i][2] == k && bits < 26) cur++;
            else if (Math.min(bits + 1, 26) <= k) cur--;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
