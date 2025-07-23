class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            int t = x;
            x = y;
            y = t;
            s = new StringBuilder(s).reverse().toString();
        }

        int a = 0, b = 0, res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                if (a > 0) {
                    a--;
                    res += x;
                } else {
                    b++;
                }
            } else {
                res += Math.min(a, b) * y;
                a = b = 0;
            }
        }
        res += Math.min(a, b) * y;
        return res;
    }
}