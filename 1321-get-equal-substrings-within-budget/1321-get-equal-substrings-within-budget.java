class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0, sLen = s.length(), tLen = t.length(), count = 0, max = 0;
        
        // abcd
        // cdef

        while(r<sLen) {
            int currDiff = Math.abs(s.charAt(r) - t.charAt(r));
            // System.out.println(currDiff);
            count += currDiff;
            
            while(l <= r && count > maxCost) {
                count -= Math.abs(s.charAt(l) - t.charAt(l));
                System.out.println(count);
                l++;
            }
            max = Math.max(max, (r-l)+1);
            r++;
        }
        return max;
    }
}