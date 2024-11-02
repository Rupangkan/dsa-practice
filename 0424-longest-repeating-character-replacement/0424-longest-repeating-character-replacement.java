class Solution {
    int slidingWindow(String s, int k) {
        int n = s.length();
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int temp = k;
        int[] hash = new int[26];
        HashMap<Character, Integer> hs = new HashMap<>();
        // "AABABBA"
        while(r<n) {
            hash[(int)s.charAt(r) - 'A']++;
            // hs.put(s.charAt(r), hs.getOrDefault(s.charAt(r), 0)+1);
            maxFreq = Math.max(maxFreq, hash[(int) s.charAt(r) - 'A']);
            while((r-l+1)-maxFreq > k) {
                hash[(int)s.charAt(l) - 'A']--;
                maxFreq = 0;
                for(int i = 0; i<26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                l++;
            }
            if(((r-l)+1)-maxFreq <= k) {
                maxLen = Math.max(maxLen, ((r-l)+1));
            }
            r++;
        }

        return maxLen;
    }

    public int characterReplacement(String s, int k) {
        return slidingWindow(s, k);
    }
}