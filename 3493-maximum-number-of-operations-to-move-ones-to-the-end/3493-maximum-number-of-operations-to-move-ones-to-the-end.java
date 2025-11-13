class Solution {
    public int maxOperations(String s) {
        int ones = 0, ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                while (i + 1 < n && s.charAt(i + 1) == '0') i++;
                ans += ones;
            } else ones++;
        }
        return ans;
    }
}
