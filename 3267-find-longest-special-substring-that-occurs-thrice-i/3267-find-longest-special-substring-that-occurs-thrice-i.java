class Solution {
    public int maximumLength(String s) {
        HashMap<Pair<Character, Integer>, Integer> c = new HashMap<>();
        int sub = 0, ans = 0, n = s.length();

        for(int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            sub = 0;

            for(int j = i; j<n; j++) {
                if(ch == s.charAt(j)) {
                    sub++;
                    Pair<Character, Integer> k = new Pair<>(ch, sub);
                    c.put(k, c.getOrDefault(k, 0) + 1);
                } else break;
            }
        } 

        for(Map.Entry<Pair<Character, Integer>, Integer> e: c.entrySet()) {
            int l = e.getKey().getValue();
            if(e.getValue() >= 3 && l > ans) {
                ans = l;
            }
        }

        return ans == 0 ? -1 : ans;
    }
}