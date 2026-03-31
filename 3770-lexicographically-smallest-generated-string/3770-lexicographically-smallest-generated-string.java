class Solution {

    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] s = new char[n + m - 1];
        int[] vis = new int[n + m - 1];

        for (int i = 0; i < s.length; i++) s[i] = 'a';

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int k = i + j;
                    if (vis[k] == 1 && s[k] != str2.charAt(j)) return "";
                    s[k] = str2.charAt(j);
                    vis[k] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean diff = false;
                int free = -1;

                for (int j = m - 1; j >= 0; j--) {
                    int k = i + j;
                    if (s[k] != str2.charAt(j)) diff = true;
                    if (free == -1 && vis[k] == 0) free = k;
                }

                if (diff) continue;
                if (free != -1) s[free] = 'b';
                else return "";
            }
        }

        return new String(s);
    }
}