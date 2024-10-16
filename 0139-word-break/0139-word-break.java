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
        boolean[] dp = new boolean[s.length() + 1];
        int n = s.length();
        dp[n] = true;
        
        for(int i = n-1; i>=0; i--) {
            for(String w: wordDict) {
                if((i+w.length())<=s.length() && s.startsWith(w, i)) {
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i]) break;
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}