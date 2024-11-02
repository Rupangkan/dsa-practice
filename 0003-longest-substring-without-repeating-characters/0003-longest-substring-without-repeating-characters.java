class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r<n) {
            int temp = s.charAt(r);
            if(map.containsKey(temp)) {
                l = Math.max(map.get(temp)+1, l);
            }
            map.put(temp, r);
            max = Math.max(max, (r-l)+1);
            r++;
        }     
        return max;   
    }
}