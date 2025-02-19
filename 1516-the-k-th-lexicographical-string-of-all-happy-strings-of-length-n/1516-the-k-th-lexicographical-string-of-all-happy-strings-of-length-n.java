class Solution {
    public String getHappyString(int n, int k) {
        if (k > 3 * (1 << (n - 1))) return "";
        StringBuilder res = new StringBuilder();
        k--;

        char ch = (char) ('a' + k / (1 << (n - 1)));
        res.append(ch);
        k %= (1 << (n - 1));

        for (int i = 1; i < n; i++) {
            int mid = 1 << (n - i - 1);
            res.append(res.charAt(i - 1) == 'a' ? (k < mid ? 'b' : 'c') : 
                       res.charAt(i - 1) == 'b' ? (k < mid ? 'a' : 'c') : 
                                                  (k < mid ? 'a' : 'b'));
            if (k >= mid) k -= mid;
        }
        return res.toString();
    }
}