class Solution {

    public String solveDp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int len = 0;
        String ans = "";
        for(int i = 0; i<n; i++) {
            dp[i][i] = true;
            for(int j = 0; j<=i; j++) {
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[i-1][j+1] == true)) {
                    dp[i][j] = true;
                    if(i-j+1 > len) {
                        len = i-j+1;
                        ans = s.substring(j, i+1);
                    }
                }
            }
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        String ans = "";
        if(n == 1) return s;
        // return solveDp(s);
        for(int i = 0; i<n; i++) {
            int l = i, r = i;

            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > len) {
                    ans = s.substring(l, r+1);
                    len = r - l + 1;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > len) {
                    ans = s.substring(l, r+1);
                    len = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return ans;
    }  
}