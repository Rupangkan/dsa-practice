class Solution {

    boolean solve(String s, List<String> wordDict, int[] dp) {
        if(s.length() == 0) return true;
        if(dp[s.length()] != 0) return dp[s.length()] == 1 ? true: false;

        for(int i = 0; i<s.length(); i++) {
            String left = s.substring(0, i+1);
            if(wordDict.contains(left)) {
                String right = s.substring(i+1);
                if(solve(right, wordDict, dp)) {
                    dp[s.length()] = 1;
                    return true;
                }
            } 
        }

        dp[s.length()] = -1;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        // Arrays.fill(dp, -1);
        return solve(s, wordDict, dp);
    }
}