class Solution {
    private String rep(int n, int a, int b) {
        char[] ch = String.valueOf(n).toCharArray();
        for (int i = 0; i < ch.length; i++)
            if (ch[i] - '0' == a) ch[i] = (char) ('0' + b);
        return new String(ch);
    }

    private int solve(int num) {
        int lo = num, hi = num;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                String t = rep(num, i, j);
                if (t.charAt(0) == '0') continue;
                int v = Integer.parseInt(t);
                lo = Math.min(lo, v);
                hi = Math.max(hi, v);
            }
        return hi - lo;
    }

    public int maxDiff(int num) {
        return solve(num);
    }
}