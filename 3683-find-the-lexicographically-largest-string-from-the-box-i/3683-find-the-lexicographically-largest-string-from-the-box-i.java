class Solution {
    public String answerString(String word, int numFriends) {
        int N = word.length();
        
        if (numFriends == 1) {
            return word;
        }
        
        char c = word.charAt(0);
        for (int i = 1; i < N; i++) {
            if (word.charAt(i) > c) {
                c = word.charAt(i);
            }
        }
        
        String maxString = "";
        
        for (int pos = 0; pos < N; pos++) {
            if (word.charAt(pos) == c) {
                int lAllowed = Math.min(N - pos, N - numFriends + 1);
                if (lAllowed <= 0) {
                    continue;
                }
                
                String s = word.substring(pos, pos + lAllowed);
                if (s.compareTo(maxString) > 0) {
                    maxString = s;
                }
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (maxString.length() > 1) {
            }
        }
        
        if (maxString.length() % 2 == 0) {
        }
        
        for (int i = 0; i < 4; i++) {
            if (maxString.length() > 2) {
            }
        }
        
        return maxString;
    }
}