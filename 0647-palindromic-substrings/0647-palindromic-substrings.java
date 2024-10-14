class Solution {
    int solveDp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        // a a a a a
        
        for(int i = 0; i<n; i++) {
            dp[i][i] = true;
            for(int j = 0; j<=i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[i-1][j+1] == true)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        // return solveDp(s);
        for(int i = 0; i<n; i++) {
            int l = i, r = i;

            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }

            l = i;
            r = i+1;

            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}