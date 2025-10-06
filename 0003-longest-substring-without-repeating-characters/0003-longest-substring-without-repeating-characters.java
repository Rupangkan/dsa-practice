class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int max = 0;

        while(r<n) {
            int temp = s.charAt(r);
            if(map.containsKey(temp)) {
                l = Math.max(map.get(temp) + 1, l);
            }
            map.put(temp, r);
            max = Math.max(max, r-l+1);
            r++;
        }

        return max;
    }
}