class Solution {

    public int maxRemovals(String s, String pattern, int[] target) {
        int sLen = s.length(), pLen = pattern.length(), tLen = target.length;
        int[][] dp = new int[sLen+1][pLen+1];
        for(int[] arr: dp) Arrays.fill(arr, Integer.MIN_VALUE);
        dp[0][0] = 0;

        for(int i = 1; i<=sLen; i++) {
            boolean flag = false;
            int add = 0;
            for(int k = 0; k<tLen; k++) {
                if(target[k] == i-1) {
                    add = 1;
                    break;
                }
            }
            dp[i][0] = dp[i-1][0] + add;
            for(int j = 1; j<=pLen; j++) {
                if(s.charAt(i-1) == pattern.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                }
                dp[i][j] = Math.max(dp[i][j], add+dp[i-1][j]);
            }
        }
    
        return dp[sLen][pLen];
    }
}