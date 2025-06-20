class Solution {
    private int solve(String s, int k) {
        int x = 0, y = 0, res = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'N') x++;
            else if (ch == 'S') x--;
            else if (ch == 'E') y++;
            else y--;
            int cur = Math.abs(x) + Math.abs(y) + 2 * k;
            res = Math.max(res, Math.min(cur, i + 1));
        }
        return res;
    }

    public int maxDistance(String s, int k) {
        return solve(s, k);
    }
}