class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0, r = 0;

        while(r<n) {
            char curr = s.charAt(r);
            if(map.containsKey(curr)) {
                l = Math.max(l, map.get(curr) + 1);
            }
            max = Math.max(max, r - l + 1);
            map.put(curr, r);
            r++;
        }
        return max;
    }
}