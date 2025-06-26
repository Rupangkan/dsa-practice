class Solution {
    public int longestSubsequence(String s, int k) {
        int t = 0, len = 0;
        int max = 32 - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1') {
                if (i < max && t + (1 << i) <= k) {
                    t += 1 << i;
                    len++;
                }
            } else len++;
        }
        return len;
    }
}