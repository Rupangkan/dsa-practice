class Solution {
    public int longestPalindrome(String[] words) {
        int[][] dp = new int[26][26];
        int cnt = 0, mid = 0;

        for(String s: words) {
            int a = s.charAt(0) - 'a', b = s.charAt(1) - 'a';
            if(dp[b][a] > 0) {
                dp[b][a]--;
                cnt += 4;
                if(a == b) mid--;
            } else {
                dp[a][b]++;
                if(a == b) mid++;
            }
        }

        if(mid > 0) cnt+=2;
        return cnt;
    }
}