class Solution {

    public int longestBalanced(String s) {
        int n = s.length(), ans = 0;
        int[] f = new int[26];

        for (int i = 0; i < n; i++) {
            Arrays.fill(f, 0);
            int distinct = 0, same = 0;

            for (int j = i; j < n; j++) {
                int id = s.charAt(j) - 'a';
                if (f[id] == 0) distinct++;
                f[id]++;

                int cur = f[id];
                same = 0;
                boolean ok = true;

                for (int k = 0; k < 26; k++) {
                    if (f[k] == 0) continue;
                    if (same == 0) same = f[k];
                    else if (f[k] != same) {
                        ok = false;
                        break;
                    }
                }

                if (ok) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
