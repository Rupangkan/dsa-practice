class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length(), ans = 0, start = 0;

        for (int r = k - 1; r < n; r++) {
            int l = r - k + 1;
            if (l >= start && isPalindrome(s, l, r)) {
                ans++;
                start = r + 1;
                continue;
            }

            l = r - k;
            if (l >= start && isPalindrome(s, l, r)) {
                ans++;
                start = r + 1;
            }
        }

        return ans;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}