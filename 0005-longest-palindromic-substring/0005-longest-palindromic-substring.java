class Solution {
    // Optimal 
    // On2
    // O1
    private String better(String s) {
        String ans = "";
        int len = 0, n = s.length();

        for(int i = 0; i<n; i++) {
            int left = i, right = i;
            // odd length
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = right - left + 1;
                    ans = s.substring(left, right+1);
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > len) {
                    len = right - left + 1;
                    ans = s.substring(left, right+1);
                }
                left--;
                right++;
            }
        }

        return ans;
    }

    // Manacher's algorithm
    // ON
    // ON
    private String optimal(String s) {
        StringBuilder sPrime = new StringBuilder("#");
        for(char c: s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        int n = sPrime.length();
        int[] palinRadii = new int[n];
        int center = 0, radius = 0;

        for(int i = 0; i<n; i++) {
            int mirr = 2 * center - i;

            if(i < radius) {
                palinRadii[i] = Math.min(radius - i, palinRadii[mirr]);
            }

            while((i + 1 + palinRadii[i] < n) && (i - 1 - palinRadii[i] >= 0) && 
            sPrime.charAt(i+1+palinRadii[i]) == sPrime.charAt(i - 1 - palinRadii[i])) {
                palinRadii[i]++;
            }

            if(i + palinRadii[i] > radius) {
                center = i;
                radius = i + palinRadii[i];
            }
        }

        int maxLen = 0, centerIdx = 0;

        for(int i = 0; i<n; i++) {
            if(palinRadii[i] > maxLen) {
                maxLen = palinRadii[i];
                centerIdx = i;
            }
        }
        
        int startIdx = (centerIdx - maxLen) / 2;
        String longest = s.substring(startIdx, startIdx + maxLen);
        return longest;
    }

    public String longestPalindrome(String s) {
        // return better(s);
        return optimal(s);
    }
}