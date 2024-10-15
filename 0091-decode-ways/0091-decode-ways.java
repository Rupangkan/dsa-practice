class Solution {
    boolean isValid(char c) {
        return c != '0';
    }

    boolean isValid(char f, char s) {
        if(f == '0') return false;
        if(f == '2' && s < '7') return true;
        if(f == '1') return true;
        return false;
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = isValid(s.charAt(n-1)) ? 1: 0;

        for(int i = n-2; i>=0; i--) {
            if(isValid(s.charAt(i))) {
                dp[i] = dp[i+1];
            } 
            if(isValid(s.charAt(i), s.charAt(i+1))) {
                dp[i] = dp[i+1]+dp[i+2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}