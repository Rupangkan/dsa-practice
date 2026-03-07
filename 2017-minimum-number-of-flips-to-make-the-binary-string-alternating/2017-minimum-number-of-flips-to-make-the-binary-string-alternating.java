class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            p[i][0] = (i == 0 ? 0 : p[i-1][1]) + (c=='1'?1:0);
            p[i][1] = (i == 0 ? 0 : p[i-1][0]) + (c=='0'?1:0);
        }
        int ans = Math.min(p[n-1][0], p[n-1][1]);
        if ((n&1)==1) {
            int[][] suf = new int[n][2];
            for (int i = n-1; i >= 0; i--) {
                char c = s.charAt(i);
                suf[i][0] = (i==n-1?0:suf[i+1][1]) + (c=='1'?1:0);
                suf[i][1] = (i==n-1?0:suf[i+1][0]) + (c=='0'?1:0);
            }
            for (int i = 0; i < n-1; i++) {
                ans = Math.min(ans, p[i][0] + suf[i+1][0]);
                ans = Math.min(ans, p[i][1] + suf[i+1][1]);
            }
        }
        return ans;
    }
}
