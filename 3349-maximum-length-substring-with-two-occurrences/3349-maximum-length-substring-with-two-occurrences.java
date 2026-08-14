class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int max = 0;
        outer: for(int i = 0; i<n; i++) {
            HashMap<Character, Integer> hs = new HashMap<>();
            int count = 0;
            for(int j = i; j<n; j++) {
                if(hs.containsKey(s.charAt(j))) {
                    int value = hs.get(s.charAt(j));
                    if(value == 1) {
                        hs.put(s.charAt(j), 2);
                    } else if(value == 2) {
                        break;
                    }
                } else {
                    hs.put(s.charAt(j), 1);
                }
                max = Math.max(max, (j-i)+1);
            }
        }
        return max;
    }
}