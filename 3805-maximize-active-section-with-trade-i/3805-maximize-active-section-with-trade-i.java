class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1') ones++;

        int best = 0, prevZero = -1;
        int i = 0, n = s.length();

        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;

            if (s.charAt(i) == '0') {
                int len = j - i;
                if (prevZero != -1)
                    best = Math.max(best, prevZero + len);
                prevZero = len;
            }

            i = j;
        }

        return ones + best;
    }
}