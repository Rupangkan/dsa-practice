class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longest = 0, l = 0, r = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(r<n) {
            char curr = s.charAt(r);
            if(map.containsKey(curr)) {
                l = Math.max(l, map.get(curr) + 1);
            } 
            map.put(curr, r);
            longest = Math.max(longest, r-l+1);
            r++;
        }
        return longest;
    }
}