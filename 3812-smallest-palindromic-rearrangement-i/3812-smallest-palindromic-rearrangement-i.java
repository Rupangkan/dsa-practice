class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        int m = s.length() / 2;

        for (int i = 0; i < m; i++)
            freq[s.charAt(i) - 'a']++;

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++)
            while (freq[i]-- > 0)
                left.append((char) ('a' + i));

        StringBuilder ans = new StringBuilder(left);
        if ((s.length() & 1) == 1)
            ans.append(s.charAt(m));

        ans.append(left.reverse());
        return ans.toString();
    }
}